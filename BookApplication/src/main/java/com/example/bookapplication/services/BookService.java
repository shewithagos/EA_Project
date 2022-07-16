package com.example.bookapplication.services;

import com.example.bookapplication.DTO.BookAdapter;
import com.example.bookapplication.DTO.BookCopiesAdapter;
import com.example.bookapplication.DTO.BookCopiesDTO;
import com.example.bookapplication.DTO.BookDTO;
import com.example.bookapplication.domain.Book;
import com.example.bookapplication.domain.BookCopies;
import com.example.bookapplication.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void addBook(BookDTO bookDTO) {
       Book b =  BookAdapter.getBookFromBookDTO(bookDTO);
         bookRepository.save(b);
    }
    public void updateBook(String isbn, BookCopiesDTO bookCopiesDTO) throws Exception
    {
        BookCopies b = BookCopiesAdapter.getBookCopiesFromBookCopiesDTO(bookCopiesDTO);
        Book b1 = bookRepository.findBookByIsbn(isbn);
        b1.addCopy(b);

    }
    public void deleteBook(String isbn) throws Exception {
        Book b = bookRepository.findBookByIsbn(isbn);
        bookRepository.delete(b);
    }
    public BookDTO getBookDTO(String isbn) {
        Book b = bookRepository.findBookByIsbn(isbn);
        return BookAdapter.getBookDTOFromBook(b);
    }
    public List<BookDTO> getAllBooks() {

        List<Book> books = bookRepository.findAll().stream().collect(Collectors.toList());
       List<BookDTO> bookDTOList =  books.stream().map(x -> BookAdapter.getBookDTOFromBook(x)).collect(Collectors.toList());
       return bookDTOList;
    }
    public void updateCheckoutBook(String isbn, String scanCode) throws Exception {
        Book b = bookRepository.findBookByIsbn(isbn);
        b.updateBook(scanCode);
        bookRepository.save(b);
    }
}
