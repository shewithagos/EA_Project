package com.example.bookapplication.DTO;

import com.example.bookapplication.domain.BookCopies;


public class BookCopiesAdapter {

    public static BookCopies getBookCopiesFromBookCopiesDTO(BookCopiesDTO bookCopiesDTO) {
        BookCopies bookCopies = new BookCopies(bookCopiesDTO.getScanCode());
        return bookCopies;
    }
    public static BookCopiesDTO getBookCopiesDTOFromBookCopies(BookCopies bookCopies) {
        BookCopiesDTO bookCopiesDTO = new BookCopiesDTO(bookCopies.getScanCode());
        return bookCopiesDTO;
    }
}
