package com.example.allo_bank_backend.util;

public class Unicode {
    public static int sumUnicode(String input) {
        int sum = 0;
        for (char c : input.toCharArray()) {
            sum += c;
        }
        return sum;
    }

    public static double spreadFactor(String input) {
        return (sumUnicode(input) % 1000) / 100000.0;
    }
}
