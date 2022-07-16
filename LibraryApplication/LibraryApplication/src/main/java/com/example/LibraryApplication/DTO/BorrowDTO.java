package com.example.LibraryApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowDTO {


    private long borrowNumber;
    private Date checkOutDate;
    private  Date returnDate;
    private LocalDate dueDate;
    private String isbn;
    private String scanCode;
    private boolean isReturned = false;

    public BorrowDTO(long borrowNumber, Date checkOutDate, Date returnDate, LocalDate dueDate, String isbn, String scanCode) {
        this.borrowNumber = borrowNumber;
        this.checkOutDate = checkOutDate;
        this.returnDate = returnDate;
        this.isbn = isbn;
        this.scanCode = scanCode;
        this.isReturned = false;
    }
}
