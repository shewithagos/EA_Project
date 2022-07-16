package com.example.LibraryApplication.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class CustomerTest {
    /**
     * Method under test: {@link Customer#checkOutBook(String, String, LocalDate)}
     */
    @Test
    void testCheckOutBook() {
        Customer customer = new Customer();
        customer.checkOutBook("Isbn", "Scan Code", LocalDate.ofEpochDay(1L));
        assertNull(customer.getBorrow());
    }

    /**
     * Method under test: {@link Customer#returnBook(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testReturnBook() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.example.LibraryApplication.domain.Borrow.getIsbn()" because "this.borrow" is null
        //       at com.example.LibraryApplication.domain.Customer.returnBook(Customer.java:51)
        //   In order to prevent returnBook(String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   returnBook(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new Customer()).returnBook("Isbn", "Scan Code");
    }

    /**
     * Method under test: {@link Customer#returnBook(String, String)}
     */
    @Test
    void testReturnBook2() throws Exception {
        Borrow borrow = new Borrow();
        borrow.setBorrowNumber(1L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        borrow.setCheckOutDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        borrow.setDueDate(LocalDate.ofEpochDay(1L));
        borrow.setIsbn("Isbn");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        borrow.setReturnDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        borrow.setReturned(true);
        borrow.setScanCode("Scan Code");

        Customer customer = new Customer();
        customer.setBorrow(borrow);
        customer.returnBook("Isbn", "Scan Code");
        assertSame(borrow, customer.getBorrow());
        assertEquals(0L, customer.getCustomerNumber());
    }

    /**
     * Method under test: {@link Customer#returnBook(String, String)}
     */
    @Test
    void testReturnBook3() throws Exception {
        Borrow borrow = new Borrow();
        Payment payment = new Payment();
        Reserve reserve = new Reserve();
        Customer customer = new Customer(1L, "Name", "jane.doe@example.org", borrow, payment, reserve);
        customer.returnBook("Isbn", "Scan Code");
        assertSame(borrow, customer.getBorrow());
        assertSame(reserve, customer.getReserve());
        assertEquals(1L, customer.getCustomerNumber());
        assertEquals("Name", customer.getName());
        assertSame(payment, customer.getPayment());
        assertEquals("jane.doe@example.org", customer.getEmail());
    }

    /**
     * Method under test: {@link Customer#returnBook(String, String)}
     */
    @Test
    void testReturnBook4() throws Exception {
        Borrow borrow = new Borrow();
        borrow.setBorrowNumber(1L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        borrow.setCheckOutDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        borrow.setDueDate(LocalDate.ofEpochDay(1L));
        borrow.setIsbn("Isbn");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        borrow.setReturnDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        borrow.setReturned(false);
        borrow.setScanCode("Scan Code");

        Customer customer = new Customer();
        customer.setBorrow(borrow);
        customer.returnBook("Isbn", "Scan Code");
        assertTrue(customer.getBorrow().isReturned());
    }

    /**
     * Method under test: {@link Customer#returnBook(String, String)}
     */
    @Test
    void testReturnBook5() throws Exception {
        Borrow borrow = new Borrow();
        borrow.setBorrowNumber(1L);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        borrow.setCheckOutDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        borrow.setDueDate(LocalDate.ofEpochDay(1L));
        borrow.setIsbn("Isbn");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        borrow.setReturnDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        borrow.setReturned(true);
        borrow.setScanCode("com.example.LibraryApplication.domain.Borrow");

        Customer customer = new Customer();
        customer.setBorrow(borrow);
        customer.returnBook("Isbn", "Scan Code");
        assertSame(borrow, customer.getBorrow());
        assertEquals(0L, customer.getCustomerNumber());
    }

    /**
     * Method under test: {@link Customer#OutstandingPayment(double, Librerian)}
     */
    @Test
    void testOutstandingPayment() {
        Customer customer = new Customer();

        Librerian librerian = new Librerian();
        librerian.setFirstName("Jane");
        librerian.setId(123L);
        librerian.setLastName("Doe");
        customer.OutstandingPayment(10.0d, librerian);
        Payment payment = customer.getPayment();
        assertEquals(10.0d, payment.getAmount());
        assertSame(librerian, payment.getLibrerian());
    }

    /**
     * Method under test: {@link Customer#OutstandingPayment(double, Librerian)}
     */
    @Test
    void testOutstandingPayment2() {
        Customer customer = new Customer();

        Librerian librerian = new Librerian();
        librerian.setFirstName("Jane");
        librerian.setId(123L);
        librerian.setLastName("Doe");
        customer.OutstandingPayment(10.0d, librerian);
        Payment payment = customer.getPayment();
        assertEquals(10.0d, payment.getAmount());
        assertSame(librerian, payment.getLibrerian());
    }
}

