package com.jinnyjinnyjinjin.projecteseok.service.expense;

import com.jinnyjinnyjinjin.projecteseok.api.response.ExpenseTotalAmountResponse;
import com.jinnyjinnyjinjin.projecteseok.domain.expense.entity.ExpenseItemsEntity;
import com.jinnyjinnyjinjin.projecteseok.domain.expense.repository.ExpenseItemsRepository;
import com.jinnyjinnyjinjin.projecteseok.service.expense.dto.ExpenseItemsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseItemsRepository expenseRepository;

    public ExpenseTotalAmountResponse getAllCurrentMonthList(LocalDate startDate, LocalDate endDate) {

        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        LocalDate firstDate = now.withDayOfMonth(1);
        LocalDate lastDate = firstDate.plusDays(now.lengthOfMonth());

        if (!ObjectUtils.isEmpty(startDate) || !ObjectUtils.isEmpty(endDate)) {
            firstDate = startDate;
            lastDate = endDate;
        }

        List<ExpenseItemsEntity> results =
                expenseRepository.findAllBySpentDateGreaterThanEqualAndSpentDateLessThanEqualOrderBySpentDateDescCreatedAtDesc(firstDate, lastDate);

        int totalSpent = results.stream()
                .mapToInt(ExpenseItemsEntity::getSpent)
                .sum();

        int totalIncome = results.stream()
                .mapToInt(ExpenseItemsEntity::getIncome)
                .sum();

        return ExpenseTotalAmountResponse.builder()
                .expenses(results.stream()
                        .map(ExpenseItemsDto::create)
                        .collect(toList()))
                .totalSpent(totalSpent)
                .totalIncome(totalIncome)
                .build();
    }

    public void createOne(LocalDate spendDate, String description, int spent, int income) {

        if (ObjectUtils.isEmpty(spendDate)) {
            log.error("create - 지출 날짜 값 없음");
            throw new IllegalArgumentException("날짜를 입력하세요.");
        }

        ExpenseItemsEntity entity = ExpenseItemsEntity.create(
                spendDate,
                description,
                spent,
                income);

        expenseRepository.save(entity);
    }

    @Transactional
    public void updateOne(Long id, LocalDate spendDate, String description, int spent, int income) {

        if (ObjectUtils.isEmpty(spendDate)) {
            log.error("update - 지출 날짜 값 없음");
            throw new IllegalArgumentException("날짜를 입력하세요.");
        }

        ExpenseItemsEntity found = expenseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 지출 내역이 없습니다. id=" + id));

        found.update(spendDate, description, spent, income);
    }

    public void deleteOne(Long id) {
        expenseRepository.deleteById(id);
    }
}
