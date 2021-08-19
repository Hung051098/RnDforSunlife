package com.hung.springh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class H2dbApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2dbApplication.class, args);
	}

}
