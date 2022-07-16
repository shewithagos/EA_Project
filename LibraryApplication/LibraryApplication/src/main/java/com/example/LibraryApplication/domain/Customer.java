package com.example.LibraryApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long customerNumber;
    private String name;
    private String email;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="borrow")
    private Borrow borrow;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="payment")
    private Payment payment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="reserve")
    private Reserve reserve;

    public  Customer(String name, String email) {
        this.name = name;
        this.email =  email;
    }

    public Customer(String name, String email, Borrow borrow) {
        this.name = name;
        this.email = email;
        this.borrow = borrow;
    }

    public void reserveBook(String isbn) {
        Reserve reserve = new Reserve();
        reserve.setIsbn(isbn);
        this.reserve = reserve;
}

    public void checkOutBook(String isbn ,String scanCode, LocalDate dueDate) {
        Borrow b = new Borrow();
        b.setIsbn(isbn);
        b.setScanCode(scanCode);
        b.setDueDate(dueDate);
         this.borrow = borrow;
    }
    public void returnBook(String isbn , String scanCode) throws Exception {
        if(borrow.getIsbn()==isbn && borrow.getScanCode()==scanCode) {
            if(borrow.isReturned()==false) {
                borrow.setReturned(true);
            }
        }
    }
    public void OutstandingPayment(double amount,Librerian librerian) {
        Payment payment = new Payment(amount,librerian);
        this.payment = payment;
    }


}
