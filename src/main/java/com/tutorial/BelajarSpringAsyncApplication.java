package com.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync //  Spring Boot akan mengaktifkan fitur Spring Async (Blocking)
@SpringBootApplication
public class BelajarSpringAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringAsyncApplication.class, args);
	}

}
