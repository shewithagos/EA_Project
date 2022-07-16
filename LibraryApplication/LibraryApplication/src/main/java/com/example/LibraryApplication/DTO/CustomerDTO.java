package com.example.LibraryApplication.DTO;

import com.example.LibraryApplication.domain.Borrow;
import com.example.LibraryApplication.domain.Payment;
import com.example.LibraryApplication.domain.Reserve;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {


    private long customerNumber;
    private String name;
    private String email;

    private Borrow borrow;

    private Payment payment;

    private Reserve reserve;

    public  CustomerDTO(String name, String email) {
        this.name = name;
        this.email =  email;
    }




}
