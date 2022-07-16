package com.example.bookapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private String isbn;
    private String title;
    private List<BookCopiesDTO> list = new ArrayList<>();
    private List<AuthorDTO> authorList = new ArrayList<>();



    public BookDTO(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public void addBookDTOCopies(BookCopiesDTO bookCopies) {
        list.add(bookCopies);
    }
    public void addAuthorDTO (AuthorDTO author) {
        authorList.add(author);
    }


}
