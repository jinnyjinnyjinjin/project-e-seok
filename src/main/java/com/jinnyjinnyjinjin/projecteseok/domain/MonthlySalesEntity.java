package com.jinnyjinnyjinjin.projecteseok.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "MONTHLY_SALES")
public class MonthlySalesEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private LocalDate month;

    private int amount;

    protected MonthlySalesEntity() {
    }

    public MonthlySalesEntity(LocalDate month, int amount) {
        this.month = month;
        this.amount = amount;
    }
}
