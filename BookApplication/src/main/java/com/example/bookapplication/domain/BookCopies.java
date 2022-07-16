package com.example.bookapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class BookCopies {
    @Id
    private String scanCode;
    private boolean isAvailable = true;

    public BookCopies(String scanCode) {
        this.scanCode = scanCode;
        this.isAvailable=true;
    }


}
