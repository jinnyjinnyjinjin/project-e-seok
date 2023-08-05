package com.jinnyjinnyjinjin.projecteseok.api;

import com.jinnyjinnyjinjin.projecteseok.api.request.ExpenseCreateRequest;
import com.jinnyjinnyjinjin.projecteseok.api.request.ExpenseUpdateRequest;
import com.jinnyjinnyjinjin.projecteseok.api.response.ExpenseTotalAmountResponse;
import com.jinnyjinnyjinjin.projecteseok.service.expense.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<ApiResponse> findAll(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                               @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

        ExpenseTotalAmountResponse response = expenseService.getAllCurrentMonthList(startDate, endDate);
        return new ResponseEntity<>(new ApiResponse(
                true,
                "Successfully found.",
                response),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody ExpenseCreateRequest request) {

        expenseService.createOne(
                request.getSpentDate(),
                request.getDescription(),
                request.getSpent(),
                request.getIncome()
        );
        return new ResponseEntity<>(new ApiResponse(
                true,
                "Successfully created."),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id,
                                              @RequestBody ExpenseUpdateRequest request) {
        expenseService.updateOne(
                id,
                request.getSpentDate(),
                request.getDescription(),
                request.getSpent(),
                request.getIncome()
        );

        return new ResponseEntity<>(new ApiResponse(
                true,
                "Successfully updated."),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        expenseService.deleteOne(id);
        return new ResponseEntity<>(new ApiResponse(
                true,
                "Successfully deleted."),
                HttpStatus.OK);
    }
}
