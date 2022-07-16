package com.example.LibraryApplication.Repository;

import com.example.LibraryApplication.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByCustomerNumber(long customerNumber);

}
