package com.jinnyjinnyjinjin.projecteseok.domain.expense.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Table(name = "expense_items")
public class ExpenseItemsEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate spentDate;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

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

    public void update(LocalDate spendDate, String description, int spent, int income) {
        this.spentDate = spendDate;
        this.description = description;
        this.spent = spent;
        this.income = income;
    }
}
