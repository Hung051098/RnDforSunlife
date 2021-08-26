package com.example.service1;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.service1.model.Address;
import com.example.service1.model.Person;
import com.example.service1.repository.AddressRepository;
import com.example.service1.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@EnableJpaRepositories
@EnableEurekaClient
public class Configservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Configservice1Application.class, args);
	}
}
