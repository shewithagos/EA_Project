package com.example.LibraryApplication.EmailSender;

import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    public static void sendEmail(String email,String message) {
        System.out.println("Sending Email To " + email );
        System.out.println("Message : " + message);
    }
}
