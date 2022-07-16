package com.example.LibraryApplication.DTO;

import com.example.LibraryApplication.domain.Customer;


public class CustomerAdapter {
    public static Customer getCustomerFromCustomerDTO(CustomerDTO customerDTO){
        Customer customer = new Customer(customerDTO.getName(),customerDTO.getEmail());
        return customer;
    }

    public static CustomerDTO getCustomerDTOFromCustomer(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO(customer.getName(),customer.getEmail());
        return customerDTO;
    }
}
