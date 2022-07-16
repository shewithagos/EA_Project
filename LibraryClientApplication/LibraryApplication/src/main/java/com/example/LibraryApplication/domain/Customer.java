package com.example.LibraryApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {


    private long customerNumber;
    private String name;
    private String email;

    private Borrow borrow;

    private Payment payment;

    private Reserve reserve;

    public  Customer(String name, String email) {
        this.name = name;
        this.email =  email;
    }

    public Customer(String name, String email, Borrow borrow) {
        this.name = name;
        this.email = email;
        this.borrow = borrow;
    }






}
