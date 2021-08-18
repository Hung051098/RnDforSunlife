package com.example.service1.service.impl;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service1.model.Customer;
import com.example.service1.repository.CustomerRepository;
import com.example.service1.repository.criteria.CustomnerRepositoryCriteria;
import com.example.service1.service.CustomerService;


@Service
public class CustomerServicerImpl implements CustomerService {

	@Autowired
	CustomnerRepositoryCriteria customerRepositoryCriteria;
	
	@Override
	public JSONObject getListCustomer() {
		// TODO Auto-generated method stub
		JSONObject data = new JSONObject();
		List<Customer> lst = customerRepositoryCriteria.getCustomer();
		data.put("data", lst);
		return data;
	}

	@Override
	public JSONObject getCustomerById(int id) {

		JSONObject data = new JSONObject();
		Customer entity = customerRepositoryCriteria.getCustomerById(id);
		data.put("data", entity);
		return data;
	}

}
