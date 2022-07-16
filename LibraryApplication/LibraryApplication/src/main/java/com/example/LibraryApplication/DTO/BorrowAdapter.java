package com.example.LibraryApplication.DTO;

import com.example.LibraryApplication.domain.Borrow;


public class BorrowAdapter {
    public static Borrow getBorrowFromBorrowDTO(BorrowDTO borrowDTO) {
        Borrow borrow = new Borrow(borrowDTO.getBorrowNumber(),borrowDTO.getCheckOutDate(),
                borrowDTO.getReturnDate(),borrowDTO.getDueDate(),borrowDTO.getIsbn(),borrowDTO.getScanCode());

        return borrow;

    }
    public static BorrowDTO getBorrowDTOFromBorrow(Borrow borrow) {
        BorrowDTO borrowDTO = new BorrowDTO(borrow.getBorrowNumber(),borrow.getCheckOutDate(),
                borrow.getReturnDate(),borrow.getDueDate(), borrow.getIsbn(), borrow.getScanCode());
        return borrowDTO;
    }
}
