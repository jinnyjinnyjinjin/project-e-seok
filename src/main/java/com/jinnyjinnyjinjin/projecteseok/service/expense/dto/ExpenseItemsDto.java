package com.jinnyjinnyjinjin.projecteseok.service.expense.dto;

import com.jinnyjinnyjinjin.projecteseok.domain.expense.entity.ExpenseItemsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseItemsDto {

    private Long id;
    private LocalDate spentDate;
    private String description;
    private int spent;
    private int income;

    public static ExpenseItemsDto create(ExpenseItemsEntity entity) {
        return ExpenseItemsDto.builder()
                .id(entity.getId())
                .spentDate(entity.getSpentDate())
                .description(entity.getDescription())
                .spent(entity.getSpent())
                .income(entity.getIncome())
                .build();
    }
}
