package com.basepackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.basepackage")

public class BookshareApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshareApplication.class, args);
		
		System.out.println("Welocme to the book worlD");
	}

}
