package com.example.LibraryApplication.service;

import com.example.LibraryApplication.DTO.CustomerAdapter;
import com.example.LibraryApplication.DTO.CustomerDTO;
import com.example.LibraryApplication.EmailSender.EmailSender;
import com.example.LibraryApplication.Integration.bookcatalog.BookClient;
import com.example.LibraryApplication.Repository.CustomerRepository;
import com.example.LibraryApplication.Repository.LibrerianRepository;
import com.example.LibraryApplication.Repository.PaymentRepository;
import com.example.LibraryApplication.Repository.ReserveRepository;
import com.example.LibraryApplication.configuration.ApplicationProperties;
import com.example.LibraryApplication.domain.Customer;
import com.example.LibraryApplication.domain.book.Book;
import com.example.LibraryApplication.domain.book.BookCopies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    LibrerianRepository librerianRepository;
    @Autowired
    ReserveRepository reserveRepository;

    @Autowired
    BookClient bookClient;
    @Autowired
    EmailSender emailSender;


    @Autowired
    ApplicationProperties applicationProperties;

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> list = customerRepository.findAll().stream().map(x -> CustomerAdapter.getCustomerDTOFromCustomer(x))
                .collect(Collectors.toList());

        return  list;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) throws Exception {
         Customer c = CustomerAdapter.getCustomerFromCustomerDTO(customerDTO);
        customerRepository.save(c);
        return  customerDTO;
    }
    public CustomerDTO updateCustomer(long customerNumber, CustomerDTO customerDTO) throws Exception{
        Customer c = customerRepository.findCustomerByCustomerNumber(customerNumber);
        c.setName(customerDTO.getName());
        c.setEmail(customerDTO.getEmail());
        customerRepository.save(c);
        return customerDTO;
    }
    public CustomerDTO getCustomer(long customerNumber) throws  Exception {
        Customer c = customerRepository.findCustomerByCustomerNumber(customerNumber);
        return CustomerAdapter.getCustomerDTOFromCustomer(c);
    }
    public void deleteCustomer(long customerNumber) throws Exception {
        Customer c = customerRepository.findCustomerByCustomerNumber(customerNumber);
        customerRepository.delete(c);
    }

    public void reserveBook(long customerNumber,String isbn ) {
        Customer customer = customerRepository.findCustomerByCustomerNumber(customerNumber);
        customer.reserveBook(isbn);
    }
    public void checkOutBook(long customerNumber, String isbn) throws Exception {
        Book book = bookClient.getBook(isbn);
        List<BookCopies> copies = book.getCopyList().stream().filter(x -> x.isAvailable()).collect(Collectors.toList());
        if(copies.size()==0) {
            throw new Exception();
        }
        String scanCode = copies.get(0).getScanCode();
        LocalDate dueDate = LocalDate.now().plusDays(applicationProperties.getMaxDaysBorrow());
        Customer c = customerRepository.findCustomerByCustomerNumber(customerNumber);
        c.checkOutBook( isbn,scanCode, dueDate);
        customerRepository.save(c);
    }
    public void returnBook(long customerNumber, String isbn, String scanCode) throws Exception {
        Customer c = customerRepository.findCustomerByCustomerNumber(customerNumber);
         List<Long> list = reserveRepository.findByIsbnAndActiveTrue(isbn);
        for(long d: list){
            Customer cust = customerRepository.findCustomerByCustomerNumber(customerNumber);
            String email = cust.getEmail();

                EmailSender.sendEmail(email,  "Book is available");
        }
        c.returnBook(isbn, scanCode);
        customerRepository.save(c);

    }
    public void outstandingFee(long customerNumber, double amount) {
        Customer c = customerRepository.findCustomerByCustomerNumber(customerNumber);
         c.OutstandingPayment(amount, null);
         customerRepository.save(c);
    }


}
