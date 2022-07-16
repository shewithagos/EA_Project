package com.example.LibraryApplication.controller;

import com.example.LibraryApplication.DTO.BorrowDTO;
import com.example.LibraryApplication.DTO.CustomerDTO;
import com.example.LibraryApplication.DTO.PaymentDTO;
import com.example.LibraryApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers(){
        List<CustomerDTO> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    @GetMapping("/customers/{customerNumber}")
    public ResponseEntity<?> getCustomerByCustomerNumber(@PathVariable(name="customerNumber") long customerNumber) throws  Exception {
        CustomerDTO customerDTO = customerService.getCustomer(customerNumber);
        return new ResponseEntity<>(customerDTO,HttpStatus.OK);
    }
    @PostMapping("/customers")
    public ResponseEntity<?> addCustomer( @RequestBody CustomerDTO customerDTO) throws Exception {
        CustomerDTO customer = customerService.createCustomer(customerDTO);
        return new ResponseEntity<CustomerDTO>(customer, HttpStatus.OK);
    }

    @PutMapping("/customers/{customerNumber}")
    public ResponseEntity<?> updateBook(@PathVariable long customerNumber, @RequestBody CustomerDTO customerDTO) throws  Exception {
        CustomerDTO customer = customerService.updateCustomer(customerNumber, customerDTO);
        return new ResponseEntity<CustomerDTO>(customer, HttpStatus.OK);
    }
    @DeleteMapping("/customers/{customerNumber}")
    public ResponseEntity<?> deleteBook(@PathVariable long customerNumber) throws  Exception {
        customerService.deleteCustomer(customerNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/customers/reserve-book")
    public ResponseEntity<?> reserveBook(@RequestBody BorrowDTO borrowDTO) throws Exception {
        customerService.reserveBook(borrowDTO.getBorrowNumber(), borrowDTO.getIsbn());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/customers/checkout-book")
    public ResponseEntity<?> checkoutBook(@RequestBody BorrowDTO borrowDTO) throws Exception {
        customerService.checkOutBook(borrowDTO.getBorrowNumber(), borrowDTO.getIsbn());
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/customers/")
    public ResponseEntity<?> returnBook(@RequestBody BorrowDTO borrowDTO) throws Exception {
        customerService.returnBook(borrowDTO.getBorrowNumber(), borrowDTO.getIsbn(), borrowDTO.getScanCode());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/pay-outstanding")
    public ResponseEntity<?> payFee(@RequestBody PaymentDTO paymentDTO) throws Exception {
        customerService.outstandingFee(paymentDTO.getPaymentNumber(), paymentDTO.getAmount());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
