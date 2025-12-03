package com.example.allo_bank_backend.strategy;

import com.example.allo_bank_backend.util.Unicode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
public class HistoricalFetcher implements IDRDataFetcher {
    private final WebClient client;

    public HistoricalFetcher(WebClient client) {
        this.client = client;
    }

    @Override
    public Object fetch() {
        try {
            return client.get()
                    .uri("/2024-01-01..2024-01-05?from=IDR&to=USD")
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
        } catch (Exception ex) {
            throw new RuntimeException("Failed to fetch historical IDR to USD", ex);
        }

    }

    @Override
    public String getType() {
        return "historical_idr_usd";
    }
}
