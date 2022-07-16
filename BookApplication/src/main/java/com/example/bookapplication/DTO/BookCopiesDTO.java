package com.example.bookapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookCopiesDTO {
    private String scanCode;
    private boolean isAvailable = true;

    public BookCopiesDTO(String scanCode) {
        this.scanCode = scanCode;
        this.isAvailable = true;
    }



}
