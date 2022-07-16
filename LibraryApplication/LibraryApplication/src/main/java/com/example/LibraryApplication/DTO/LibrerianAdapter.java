package com.example.LibraryApplication.DTO;

import com.example.LibraryApplication.domain.Librerian;

public class LibrerianAdapter {

    public static LibrerianDTO getLibrerianDTOFromLibrerian(Librerian librerian) {
        LibrerianDTO librerianDTO = new LibrerianDTO(librerian.getId(),librerian.getFirstName(),librerian.getLastName());
       return librerianDTO;
    }
    public static Librerian getLibrerianFromLibrerianDTO(LibrerianDTO librerianDTO) {
        Librerian  librerian = new Librerian(librerianDTO.getId(), librerianDTO.getFirstName(),
                librerianDTO.getLastName());
        return librerian;
    }
}
