package com.example.LibraryApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Librerian {
    @Id
    private long id;
    private String firstName;
    private String lastName;
}
