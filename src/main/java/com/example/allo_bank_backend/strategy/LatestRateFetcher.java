package com.example.allo_bank_backend.strategy;

import com.example.allo_bank_backend.util.Unicode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
public class LatestRateFetcher implements IDRDataFetcher {
    private final WebClient client;

    @Value("${internal.git-username}")
    private String gitUsername;

    public LatestRateFetcher(WebClient client) {
        this.client = client;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object fetch() {

        Map<String, Object> data = client.get()
                .uri("/latest?base=IDR")
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        if (data == null || data.get("rates") == null) {
            throw new IllegalStateException("Missing 'rates' field in response");
        }

        Map<String, Double> rates = (Map<String, Double>) data.get("rates");
        double usdRate = rates.get("USD");

        double spreadFactor = Unicode.spreadFactor(gitUsername);

        double spread = (1 / usdRate) * (1 + spreadFactor);

        data.put("USD_BuySpread_IDR", spread);

        return data;
    }

    @Override
    public String getType() {
        return "latest_idr_rates";
    }
}
