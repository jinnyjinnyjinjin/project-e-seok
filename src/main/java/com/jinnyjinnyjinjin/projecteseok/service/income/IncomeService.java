package com.jinnyjinnyjinjin.projecteseok.service.income;

import com.jinnyjinnyjinjin.projecteseok.api.request.IncomeCreateRequest;
import com.jinnyjinnyjinjin.projecteseok.domain.income.entity.IncomeItemsEntity;
import com.jinnyjinnyjinjin.projecteseok.domain.income.repository.IncomeItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeService {

    private final IncomeItemsRepository incomeItemsRepository;

    public int getAllTotalIncomeAmount() {

        LocalDate now = LocalDate.now();
        Month month = now.getMonth();
        int year = now.getYear();
        LocalDate from = LocalDate.of(year, month, 1);
        List<IncomeItemsEntity> recentIncomes = incomeItemsRepository.findAllByIncomeDateGreaterThanEqual(from);

        int totalAmount = recentIncomes.stream()
                .mapToInt(IncomeItemsEntity::getAmount)
                .sum();

        return totalAmount;
    }

    public void createIncome(IncomeCreateRequest request) {

        IncomeItemsEntity incomeItemsEntity = IncomeItemsEntity.builder()
                .amount(request.getAmount())
                .description(request.getDescription())
                .incomeDate(request.getIncomeDate())
                .build();

        incomeItemsRepository.save(incomeItemsEntity);
    }
}
