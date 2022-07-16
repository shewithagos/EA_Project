package com.example.bookapplication.DTO;

import java.util.ArrayList;
import java.util.Collection;

public class BooksDTO {
    private Collection<BookDTO> books = new ArrayList<>();

    public BooksDTO(Collection<BookDTO> books) {
        this.books = books;
    }
    public BooksDTO() {}

    public Collection<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(Collection<BookDTO> books) {
        this.books = books;
    }
}
