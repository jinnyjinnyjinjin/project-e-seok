package com.jinnyjinnyjinjin.projecteseok.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "EXPENSE_ITEMS")
public class ExpenseItemsEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private LocalDate spentDate;

    @CreatedDate
    private LocalDateTime createdAt;

    private String description;

    private int spent;

    private int income;

    protected ExpenseItemsEntity() {
    }

    public ExpenseItemsEntity(LocalDate spentDate, String description, int spent, int income) {
        this.spentDate = spentDate;
        this.description = description;
        this.spent = spent;
        this.income = income;
    }

    public static ExpenseItemsEntity create(LocalDate spentDate, String description, int spent, int income) {
        return new ExpenseItemsEntity(
                spentDate,
                description,
                spent,
                income
        );
    }
}
