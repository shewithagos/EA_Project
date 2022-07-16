package com.example.bookapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Book {
    @Id
    private String isbn;
    private String title;
    private List<BookCopies> copyList = new ArrayList<>();
    private List<Author> authorList = new ArrayList<>();

    public Book (String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
    public void addCopy(BookCopies copies) {
        copyList.add(copies);
    }
    public void addAuthor(Author author) {
        authorList.add(author);
    }
    public void updateBook(String scanCode) {
        BookCopies bookCopy = copyList.stream().filter(b -> b.getScanCode().equals(scanCode)).findFirst().get();
        bookCopy.setAvailable(false);
    }

}
