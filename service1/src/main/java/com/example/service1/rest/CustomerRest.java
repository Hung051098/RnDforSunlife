package com.example.service1.rest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.service1.service.CustomerService;

@RestController
@RequestMapping("/customer")
@RequestScope
public class CustomerRest {
	@Value("${sample.example}")
	String example;

	@Autowired
	CustomerService customerService;

	@RequestMapping("/list_customer")
	public JSONObject getListCustomer() {
		return customerService.getListCustomer();
	}

	@RequestMapping("/get_customer_by_id")
	public JSONObject getCustomerById(@RequestParam int id ) {
		return customerService.getCustomerById(id);
	}

	@RequestMapping("/getconfig")
	public String getconfig( ) {
		return example;
	}
}
