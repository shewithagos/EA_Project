package com.example.bookapplication;


import com.example.bookapplication.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BookClientApplication implements CommandLineRunner {

    RestTemplate restTemplate = new RestTemplate();
    private String serverUrl = "http://localhost:8081/books";



    public static void main(String[] args) {
        SpringApplication.run(BookClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        restTemplate.postForLocation(serverUrl, new Book("200", "Harry Potter"));

//        Book book = restTemplate.getForObject(serverUrl + "/{isbn}" ,Book.class, "123");
//
//        System.out.println(book);





    }
}
