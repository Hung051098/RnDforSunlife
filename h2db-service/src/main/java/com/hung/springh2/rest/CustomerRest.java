package com.hung.springh2.rest;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hung.springh2.dto.response.CustomerDTO;
import com.hung.springh2.request.AddCustomerRequest;
import com.hung.springh2.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerRest {

	@Autowired
	CustomerService customerService;

	@GetMapping("/list_customer")
	public List<CustomerDTO> getListCustomer() {
		return customerService.getListCustomer();
	}

	@GetMapping("/get_customer_by_id")
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

	@PutMapping("/update_customer/{id}")
	public JSONObject updateCustomerById(@PathVariable int id, @RequestBody AddCustomerRequest request) {
		System.out.println(id);
		return customerService.updateCustomerById(id, request);
	}
	
	@DeleteMapping("/users/{id}")
    public JSONObject deleteUser(@PathVariable("id") Integer id) {
		return customerService.deleteById(id);
    }
}
