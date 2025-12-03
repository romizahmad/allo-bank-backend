package com.example.allo_bank_backend.controller;

import com.example.allo_bank_backend.service.MemoryStoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    private final MemoryStoreService store;

    public FinanceController(MemoryStoreService store) {
        this.store = store;
    }

    @GetMapping("/data/{resourceType}")
    public ResponseEntity<?> getData(@PathVariable String resourceType) {
        Object data = store.get(resourceType);

        return ResponseEntity.ok(data);
    }
}
