package com.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // Spring Boot akan mengaktifkan fitur spring Async Timer (proses yang bisa berjalan sendiri)
@EnableAsync //  Spring Boot akan mengaktifkan fitur Spring Async (Blocking)
@SpringBootApplication
public class BelajarSpringAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringAsyncApplication.class, args);
	}

}
