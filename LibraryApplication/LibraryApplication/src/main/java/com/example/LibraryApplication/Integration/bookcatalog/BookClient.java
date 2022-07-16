package com.example.LibraryApplication.Integration.bookcatalog;

import com.example.LibraryApplication.configuration.ApplicationProperties;
import com.example.LibraryApplication.domain.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class BookClient {

    @Autowired
    ApplicationProperties applicationProperties;

    RestTemplate restTemplate = new RestTemplate();

    public Book getBook(String isbn) {
        Book book = new Book();
        try{
            book = restTemplate.getForObject(applicationProperties.getBookCatalogUrl()+ "{isbn}" , Book.class, isbn);
        }catch(Exception e) {
            System.out.println("Exception error " + e.getMessage());
        }
        return book;

    }

}
