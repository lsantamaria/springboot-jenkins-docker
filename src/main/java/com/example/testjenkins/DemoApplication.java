package com.example.testjenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class DemoApplication {

	@GetMapping()
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
