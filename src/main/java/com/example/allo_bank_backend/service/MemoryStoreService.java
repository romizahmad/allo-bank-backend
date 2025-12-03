package com.example.allo_bank_backend.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MemoryStoreService {
    private final Map<String, Object> store = new ConcurrentHashMap<>();

    public void put(String key, Object data) {
        store.put(key, data);
    }

    public Object get(String key) {
        return store.get(key);
    }
}
