package com.example.bookapplication.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Books {
    private Collection<Book> books = new ArrayList<>();

    public Books(Collection<Book> books) {
        this.books = books;
    }
    public Books() {}

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
}
