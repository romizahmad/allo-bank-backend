package com.example.allo_bank_backend.service;

import com.example.allo_bank_backend.strategy.IDRDataFetcher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoadService implements ApplicationRunner {
    private final MemoryStoreService store;
    private final List<IDRDataFetcher> fetchers;

    public DataLoadService(MemoryStoreService store, List<com.example.allo_bank_backend.strategy.IDRDataFetcher> fetchers) {
        this.store = store;
        this.fetchers = fetchers;
    }

    @Override
    public void run(ApplicationArguments args) {

        for (IDRDataFetcher fetcher : fetchers) {
            Object data = fetcher.fetch();
            store.put(fetcher.getType(), data);
        }
    }
}
