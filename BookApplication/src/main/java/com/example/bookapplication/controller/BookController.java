package com.example.bookapplication.controller;

import com.example.bookapplication.DTO.BookCopiesDTO;
import com.example.bookapplication.DTO.BookDTO;
import com.example.bookapplication.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable("isbn") String isbn) {

        BookDTO b = bookService.getBookDTO(isbn);
        if (isbn == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BookDTO>(b,HttpStatus.OK);
    }
    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable("isbn") String isbn) {
        BookDTO b = bookService.getBookDTO(isbn);
        if (isbn == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/books/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable String isbn , @RequestBody BookCopiesDTO bookCopiesDTO) {
        BookDTO b = bookService.getBookDTO(isbn);
        b.addBookDTOCopies(bookCopiesDTO);
        return new ResponseEntity<BookDTO>(b,HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
        return new ResponseEntity<BookDTO>(bookDTO,HttpStatus.OK);
    }
    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        bookService.getAllBooks();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
