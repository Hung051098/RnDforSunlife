package com.hung.springh2.service.impl;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hung.springh2.model.Customer;
import com.hung.springh2.model.User;
import com.hung.springh2.repository.CustomerRepository;
import com.hung.springh2.repository.criteria.CustomerRepositoryCriteria;
import com.hung.springh2.request.AddCustomerRequest;
import com.hung.springh2.service.CustomerService;

@Service
public class CustomerServicerImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerRepositoryCriteria customerRepositoryCriteria;

	@Override
	public JSONObject getListCustomer() {
		// TODO Auto-generated method stub
		JSONObject data = new JSONObject();
		List<Customer> lst = customerRepository.findAll();
		data.put("data", lst);
		return data;
	}

	@Override
	public JSONObject addCustomer(AddCustomerRequest request) {

		Customer customer = new Customer();
		customer.setName(request.getName());
		customer.setCreate_dt(new Date().getTime());
		customer.setEmail(request.getEmail());
		customer.setMobile_number(request.getMobile_number());
		customer.setPwd(request.getPwd());
		customer.setRole(request.getRole());
		customer = customerRepository.save(customer);
		JSONObject data = new JSONObject();
		data.put("customer", customer);
		return data;
	}

	@Override
	public JSONObject getCustomerById(int id) {

		JSONObject data = new JSONObject();
		Customer cus = customerRepositoryCriteria.getCustomerById(id);
		data.put("data", cus);
		return data;
	}
	
	@Override
	public JSONObject getListCustomerByFilter(String key_filter, String value_filter) {
		JSONObject data = new JSONObject();
		List<Customer> lst = customerRepositoryCriteria.getListCustomerFilter(key_filter, value_filter);
		data.put("data", lst);
		return data;
	}
}
