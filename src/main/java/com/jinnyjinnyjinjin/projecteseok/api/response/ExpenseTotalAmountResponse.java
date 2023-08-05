package com.jinnyjinnyjinjin.projecteseok.api.response;

import com.jinnyjinnyjinjin.projecteseok.service.expense.dto.ExpenseItemsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseTotalAmountResponse {
    private int totalSpent;
    private int totalIncome;
    private List<ExpenseItemsDto> expenses;
}
