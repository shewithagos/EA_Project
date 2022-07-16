package com.example.bookapplication.DTO;

import com.example.bookapplication.domain.Author;


public class AuthorAdapter {
    public static AuthorDTO getAuthorDTOFromAuthor(Author author) {
        AuthorDTO authorDTO = new AuthorDTO(author.getAuthorNumber(),author.getName());
        return authorDTO;
    }
    public static Author getAuthorFromAuthorDTO(AuthorDTO authorDTO) {
        Author author = new Author(authorDTO.getAuthorNumber(),authorDTO.getName());
        return author;
    }
}
