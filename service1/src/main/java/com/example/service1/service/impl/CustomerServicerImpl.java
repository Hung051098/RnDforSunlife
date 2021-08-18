package com.example.service1.service.impl;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service1.model.Customer;
import com.example.service1.repository.CustomerRepository;
import com.example.service1.service.CustomerService;


@Service
public class CustomerServicerImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public JSONObject getListCustomer() {
		// TODO Auto-generated method stub
		JSONObject data = new JSONObject();
		List<Customer> lst = customerRepository.findAll();
		data.put("data", lst);
		return data;
	}

}
