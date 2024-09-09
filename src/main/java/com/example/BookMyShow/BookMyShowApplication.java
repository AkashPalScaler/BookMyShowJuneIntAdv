package com.example.BookMyShow;

import com.example.BookMyShow.models.Booking;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication {
	public static void main(String[] args) {
		Booking booking = new Booking();
		SpringApplication.run(BookMyShowApplication.class, args);
	}
}
