package com.hung.springh2.rest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hung.springh2.request.AddCustomerRequest;
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

	@RequestMapping("/get_customer_by_id")
	public JSONObject getCustomerById(@RequestParam int id) {
		return customerService.getCustomerById(id);
	}

	@PostMapping("/add_customer")
	public JSONObject addCustomer(@RequestBody AddCustomerRequest request) {
		return customerService.addCustomer(request);
	}

	@GetMapping("/get_list_customer_by_filter")
	public JSONObject getListCustomerByFilter(@RequestParam String key_filter, @RequestParam String value_filter) {
		return customerService.getListCustomerByFilter(key_filter, value_filter);
	}
}
