package com.example.bookapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookCopies {

    private String scanCode;
    private boolean isAvailable = true;

    public BookCopies(String scanCode) {
        this.scanCode = scanCode;
        this.isAvailable=true;
    }


}
