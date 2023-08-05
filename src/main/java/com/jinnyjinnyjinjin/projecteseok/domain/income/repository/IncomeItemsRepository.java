package com.jinnyjinnyjinjin.projecteseok.domain.income.repository;

import com.jinnyjinnyjinjin.projecteseok.domain.income.entity.IncomeItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IncomeItemsRepository extends JpaRepository<IncomeItemsEntity, Long> {

    List<IncomeItemsEntity> findAllByIncomeDateGreaterThanEqual(LocalDate from);
}
