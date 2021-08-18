package com.hung.springh2.rest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hung.springh2.request.AddCustomerRequest;
import com.hung.springh2.request.AddUserRequest;
import com.hung.springh2.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRest {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/list_customer")
	public JSONObject getListCustomer() {
		return customerService.getListCustomer();
	}

	@PostMapping("/add_customer")
	public JSONObject addCustomer(@RequestBody AddCustomerRequest request) {
		return customerService.addCustomer(request);
	}
}
