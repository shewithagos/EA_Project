package com.example.LibraryApplication.DTO;

import com.example.LibraryApplication.domain.Reserve;


public class ReserveAdapter {

    public static Reserve getReserveFromResreveDTO(ReserveDTO reserveDTO) {
        Reserve reserve = new Reserve(reserveDTO.getReservationNumber(),reserveDTO.getReservationDate(),reserveDTO.getIsbn());
        return  reserve;

    }

    public static ReserveDTO getReserveDTOFromReserve(Reserve reserve) {
        ReserveDTO reserveDTO = new ReserveDTO(reserve.getReservationNumber(),reserve.getReservationDate(),reserve.getIsbn());
        return reserveDTO;
    }
}
