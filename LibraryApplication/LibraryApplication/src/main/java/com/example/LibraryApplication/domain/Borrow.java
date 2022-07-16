package com.example.LibraryApplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Borrow {
    @Id
    private long borrowNumber;
    private Date checkOutDate;
    private  Date returnDate;
    private LocalDate dueDate;
    private String isbn;
    private String scanCode;
    private boolean isReturned = false;

    public Borrow(long borrowNumber, Date checkOutDate, Date returnDate,LocalDate dueDate, String isbn, String scanCode) {
        this.borrowNumber = borrowNumber;
        this.checkOutDate = checkOutDate;
        this.returnDate = returnDate;
        this.isbn = isbn;
        this.scanCode = scanCode;
        this.isReturned = false;
    }

    public Borrow(long borrowNumber) {
        this.borrowNumber = borrowNumber;
    }
    //    public void checkOut(Book book , LocalDate checkOutDate) {
//
//            if(book.getList().stream().filter((x) -> x.isAvailable()==true).count() > 0) {
//
//                for (BookCopies copies : book.getList()) {
//                    copies.setAvailable(false);
//                }
//            }else {
//                System.out.println("All Copies are checked Out reserve the Book");
//            }
//        this.checkOutDate = checkOutDate;
//    }
//    public void returnBook(Book book , LocalDate returnDate) {
//        for(BookCopies copies : book.getList()) {
//            copies.setAvailable(true);
//        }
//        this.returnDate = returnDate;
//
//    }
//    public double penality() {
//           long a = DAYS.between(this.returnDate,this.checkOutDate);
//           if (a > 21) return a * 0.5;
//           return 0;
//    }


}
