package com.example.bookapplication.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BookTest {
    /**
     * Method under test: {@link Book#updateBook(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateBook() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.example.bookapplication.domain.Book.updateBook(Book.java:34)
        //   In order to prevent updateBook(String)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateBook(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new Book()).updateBook("Scan Code");
    }

    /**
     * Method under test: {@link Book#updateBook(String)}
     */
    @Test
    void testUpdateBook2() {
        BookCopies bookCopies = new BookCopies();
        bookCopies.setAvailable(true);
        bookCopies.setScanCode("Scan Code");

        Book book = new Book();
        book.addCopy(bookCopies);
        book.updateBook("Scan Code");
        assertFalse(book.getCopyList().get(0).isAvailable());
    }

    /**
     * Method under test: {@link Book#updateBook(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateBook3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.util.NoSuchElementException: No value present
        //       at java.util.Optional.get(Optional.java:143)
        //       at com.example.bookapplication.domain.Book.updateBook(Book.java:34)
        //   In order to prevent updateBook(String)
        //   from throwing NoSuchElementException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   updateBook(String).
        //   See https://diff.blue/R013 to resolve this issue.

        BookCopies bookCopies = new BookCopies();
        bookCopies.setAvailable(true);
        bookCopies.setScanCode("com.example.bookapplication.domain.BookCopies");

        Book book = new Book();
        book.addCopy(bookCopies);
        book.updateBook("Scan Code");
    }

    /**
     * Method under test: {@link Book#updateBook(String)}
     */
    @Test
    void testUpdateBook4() {
        BookCopies bookCopies = new BookCopies();
        bookCopies.setAvailable(true);
        bookCopies.setScanCode("Scan Code");

        BookCopies bookCopies1 = new BookCopies();
        bookCopies1.setAvailable(true);
        bookCopies1.setScanCode("com.example.bookapplication.domain.BookCopies");

        Book book = new Book();
        book.addCopy(bookCopies1);
        book.addCopy(bookCopies);
        book.updateBook("Scan Code");
        assertFalse(book.getCopyList().get(1).isAvailable());
    }
}

