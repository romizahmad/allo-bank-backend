package com.example.allo_bank_backend.strategy;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
public class SupportedCurrenciesFetcher implements IDRDataFetcher{
    private final WebClient client;

    public SupportedCurrenciesFetcher(WebClient client) {
        this.client = client;
    }

    @Override
    public Object fetch() {
        return client.get()
                .uri("/currencies")
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }

    @Override
    public String getType() {
        return "supported_currencies";
    }
}
