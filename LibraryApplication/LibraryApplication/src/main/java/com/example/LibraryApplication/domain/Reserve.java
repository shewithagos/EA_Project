package com.example.LibraryApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reserve {
    @Id
    private long reservationNumber;
    private Date reservationDate;
    private  String isbn;
    private boolean status = false;

    public Reserve(long reservationNumber, Date reservationDate, String isbn) {
        this.reservationNumber = reservationNumber;
        this.reservationDate = reservationDate;
        this.isbn = isbn;
        this.status = false;
    }
}
