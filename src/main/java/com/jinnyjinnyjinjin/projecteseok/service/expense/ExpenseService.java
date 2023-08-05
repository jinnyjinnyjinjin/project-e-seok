package com.jinnyjinnyjinjin.projecteseok.service.expense;

import com.jinnyjinnyjinjin.projecteseok.domain.expense.entity.ExpenseItemsEntity;
import com.jinnyjinnyjinjin.projecteseok.domain.expense.repository.ExpenseItemsRepository;
import com.jinnyjinnyjinjin.projecteseok.service.expense.dto.ExpenseItemsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseItemsRepository expenseRepository;

    public List<ExpenseItemsDto> getAllCurrentMonthList() {

        LocalDate now = LocalDate.now();
        LocalDate firstDate = now.withDayOfMonth(1);
        LocalDate lastDate = firstDate.plusDays(now.lengthOfMonth() - 1);

        List<ExpenseItemsEntity> results =
                expenseRepository.findAllBySpentDateBetweenOrderByCreatedAtDesc(firstDate, lastDate);

        return results.stream()
                .map(ExpenseItemsDto::create)
                .collect(toList());
    }

    public void createOne(LocalDate spendDate, String description, int spent, int income) {
        ExpenseItemsEntity entity = ExpenseItemsEntity.create(
                spendDate,
                description,
                spent,
                income);
        expenseRepository.save(entity);
    }

    @Transactional
    public void updateOne(Long id, LocalDate spendDate, String description, int spent, int income) {
        ExpenseItemsEntity found = expenseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 지출 내역이 없습니다. id=" + id));

        found.update(spendDate, description, spent, income);
    }

    public void deleteOne(Long id) {
        expenseRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public int findTotalExpenseAmount() {

        LocalDate now = LocalDate.now();
        Month month = now.getMonth();
        int year = now.getYear();
        LocalDate from = LocalDate.of(year, month, 1);
        List<ExpenseItemsEntity> recentExpenses = expenseRepository.findAllBySpentDateGreaterThanEqual(from);

        int totalAmount = recentExpenses.stream()
                .mapToInt(ExpenseItemsEntity::getSpent)
                .sum();

        return totalAmount;
    }
}
