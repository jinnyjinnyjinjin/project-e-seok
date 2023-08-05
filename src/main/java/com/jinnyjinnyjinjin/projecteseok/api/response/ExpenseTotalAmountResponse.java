package com.jinnyjinnyjinjin.projecteseok.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExpenseTotalAmountResponse {
    private int totalSpent;
    private int totalIncome;
}
