package com.example.LibraryApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibrerianDTO {
    private long id;
    private String firstName;
    private String lastName;
}
