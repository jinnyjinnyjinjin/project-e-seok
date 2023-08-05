package com.jinnyjinnyjinjin.projecteseok.domain.income.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(name = "income_items")
public class IncomeItemsEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private int amount;

    private LocalDate incomeDate;

    private String description;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    @CreatedDate
    private LocalDateTime updatedAt;

    protected IncomeItemsEntity() {
    }

    public IncomeItemsEntity(int amount, LocalDate incomeDate, String description) {
        this.amount = amount;
        this.incomeDate = incomeDate;
        this.description = description;
    }
}
