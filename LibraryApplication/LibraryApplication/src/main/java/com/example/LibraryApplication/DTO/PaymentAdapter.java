package com.example.LibraryApplication.DTO;

import com.example.LibraryApplication.domain.Payment;


public class PaymentAdapter {

    public static Payment getPaymentFromPaymentDTO(PaymentDTO paymentDTO) {
        Payment payment = new Payment(paymentDTO.getPaymentNumber(),paymentDTO.getAmount(),paymentDTO.getLibrerian());
        return payment;
    }
    public static PaymentDTO getPaymentDTOFromPayment(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO(payment.getPaymentNumber(),payment.getAmount(),payment.getLibrerian());
        return paymentDTO;
    }
}
