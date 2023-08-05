package com.jinnyjinnyjinjin.projecteseok.api.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ExpenseCreateRequest {
    private LocalDate spentDate;
    private String description;
    private int spent;
    private int income;
}
