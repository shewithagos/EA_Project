package com.example.LibraryApplication.domain.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookCopies {
    @Id
    private String scanCode;
    private boolean isAvailable = true;

    public BookCopies(String scanCode) {
        this.scanCode = scanCode;
        this.isAvailable=true;
    }


}
