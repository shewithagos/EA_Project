package com.example.bookapplication.DTO;

import com.example.bookapplication.domain.Author;
import com.example.bookapplication.domain.Book;
import com.example.bookapplication.domain.BookCopies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookAdapter {
    public static BookDTO getBookDTOFromBook(Book book) {
        BookDTO bookDTO = new BookDTO(book.getIsbn(), book.getTitle());
        for(BookCopies b : book.getCopyList()) {
            bookDTO.getList().add(BookCopiesAdapter.getBookCopiesDTOFromBookCopies(b));
        }
        for(Author a : book.getAuthorList()) {
            bookDTO.getAuthorList().add(AuthorAdapter.getAuthorDTOFromAuthor(a));
        }
       return bookDTO;
    }

    public static Book getBookFromBookDTO(BookDTO bookDTO) {
        Book book = new Book(bookDTO.getIsbn(),bookDTO.getTitle());
        for(BookCopiesDTO b : bookDTO.getList()) {
            book.getCopyList().add(BookCopiesAdapter.getBookCopiesFromBookCopiesDTO(b));
        }
        for(AuthorDTO a : bookDTO.getAuthorList()) {
            book.getAuthorList().add(AuthorAdapter.getAuthorFromAuthorDTO(a));
        }
        return book;

    }

    public static List<BookDTO> getListOfBookDTOFromBookList(List<Book> list) {
        List<BookDTO> bookDTOList = new ArrayList<>();
        for(Book book : list) {
            bookDTOList.add(getBookDTOFromBook(book));
        }
        return bookDTOList;
    }
}
