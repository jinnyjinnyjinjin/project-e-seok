package com.jinnyjinnyjinjin.projecteseok.api;

import com.jinnyjinnyjinjin.projecteseok.api.request.IncomeCreateRequest;
import com.jinnyjinnyjinjin.projecteseok.service.income.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/incomes")
public class IncomeController {

    private final IncomeService incomeService;

    @GetMapping("/total")
    public ResponseEntity<ApiResponse> findAllTotalIncomeAmount() {
        int totalAmount = incomeService.getAllTotalIncomeAmount();
        return ResponseEntity.ok(new ApiResponse(
                true,
                "Successfully get total income amount."
                , totalAmount));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createIncome(@RequestBody IncomeCreateRequest request) {
        incomeService.createIncome(request);
        return ResponseEntity.ok(new ApiResponse(
                true,
                "Successfully created."));
    }
}
