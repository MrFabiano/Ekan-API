package com.ekan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EkanApplication {

	public static void main(String[] args) {
		SpringApplication.run(EkanApplication.class, args);
	}

}
