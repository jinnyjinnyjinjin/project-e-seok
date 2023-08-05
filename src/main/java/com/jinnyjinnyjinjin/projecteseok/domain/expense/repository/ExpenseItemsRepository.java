package com.jinnyjinnyjinjin.projecteseok.domain.expense.repository;

import com.jinnyjinnyjinjin.projecteseok.domain.expense.entity.ExpenseItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseItemsRepository extends JpaRepository<ExpenseItemsEntity, Long> {
    List<ExpenseItemsEntity> findAllBySpentDateBetweenOrderByCreatedAtDesc(LocalDate from, LocalDate to);

    List<ExpenseItemsEntity> findAllBySpentDateGreaterThanEqual(LocalDate from);
}
