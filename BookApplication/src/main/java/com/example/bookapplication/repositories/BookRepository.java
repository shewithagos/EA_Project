package com.example.bookapplication.repositories;

import com.example.bookapplication.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Book findBookByIsbn(String isbn);
}
