package com.jinnyjinnyjinjin.projecteseok.api.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
public class IncomeCreateRequest {

    private int amount;
    private String description;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate incomeDate;
}
