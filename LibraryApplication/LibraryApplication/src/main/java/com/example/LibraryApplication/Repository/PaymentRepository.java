package com.example.LibraryApplication.Repository;

import com.example.LibraryApplication.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long > {
}
