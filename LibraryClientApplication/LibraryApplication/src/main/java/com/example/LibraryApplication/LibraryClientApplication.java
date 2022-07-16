package com.example.LibraryApplication;

import com.example.LibraryApplication.domain.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class LibraryClientApplication implements CommandLineRunner {

	RestTemplate restTemplate = new RestTemplate();

	private String serverUrl = "http://localhost:8080/customers";


	public static void main(String[] args) {
		SpringApplication.run(LibraryClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//restTemplate.postForLocation(serverUrl, new Customer("semir","email"));

//		// Get customer by customer number
		Customer customer = restTemplate.getForObject(serverUrl + "/{customerNumber}", Customer.class, "3");
//		System.out.println("******************* Get customer by customer number *******************");
		System.out.println(customer);











	}
}
