package com.jinnyjinnyjinjin.projecteseok.domain.expense.repository;

import com.jinnyjinnyjinjin.projecteseok.domain.expense.entity.ExpenseItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseItemsRepository extends JpaRepository<ExpenseItemsEntity, Long> {

//    @Query(
//            nativeQuery = true,
//            value = "SELECT " +
//                        "* " +
//                    "FROM expense_items expenses WHERE expenses.spent_date BETWEEN DATE_FORMAT(?1, 'yyyy-MM-dd') AND DATE_FORMAT(?2, 'yyyy-MM-dd') AND (?3 is NULL or expenses.description LIKE ?3) ORDER BY expenses.spent_date DESC, expenses.created_at DESC"
//    )
    List<ExpenseItemsEntity> findAllBySpentDateGreaterThanEqualAndSpentDateLessThanEqualOrderBySpentDateDescCreatedAtDesc(LocalDate from, LocalDate to);
//    List<ExpenseItemsEntity> findAllBySpentDateBetweenAndDescriptionIsNullOrDescriptionLikeOrderBySpentDateDescCreatedAtDesc(LocalDate from, LocalDate to, String query);
}
