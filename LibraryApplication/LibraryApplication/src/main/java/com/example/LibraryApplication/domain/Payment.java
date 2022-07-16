package com.example.LibraryApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue
    private long paymentNumber;
    private double amount;
    @ManyToOne(cascade = CascadeType.ALL)
    private Librerian librerian;

    public Payment(double amount, Librerian librerian) {
        this.amount = amount;
        this.librerian = librerian;
    }
}
