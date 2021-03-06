package com.example.LibraryApplication.DTO;

import com.example.LibraryApplication.domain.Librerian;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private long paymentNumber;
    private double amount;
    private Librerian librerian;
}
