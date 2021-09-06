package com.example.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Configservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Configservice1Application.class, args);
	}
}
