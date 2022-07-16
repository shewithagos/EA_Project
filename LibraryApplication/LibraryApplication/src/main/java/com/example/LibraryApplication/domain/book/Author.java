package com.example.LibraryApplication.domain.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Author {
    @Id
    private long authorNumber;
    private String name;




}
