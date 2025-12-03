package com.example.allo_bank_backend.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseBuilder {
    public static ResponseEntity<?> success(Object data) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", 1);
        body.put("data", data);

        return ResponseEntity.ok(body);
    }

    public static ResponseEntity<?> error(String message, HttpStatus status) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", "error");
        body.put("message", message);

        return ResponseEntity.status(status).body(body);
    }

    public static ResponseEntity<?> notFound(String message) {
        return error(message, HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<?> badRequest(String message) {
        return error(message, HttpStatus.BAD_REQUEST);
    }
}
