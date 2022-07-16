package com.example.LibraryApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Payment {
    private long paymentNumber;
    private double amount;

    private Librerian librerian;

    public Payment(double amount, Librerian librerian) {
        this.amount = amount;
        this.librerian = librerian;
    }
}
