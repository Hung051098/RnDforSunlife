package com.hung.springadapter.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.hung.springadapter.cache.EhCache;
import com.hung.springadapter.data.Customer;
import com.hung.springadapter.service.CustomerService;
import com.ibm.json.java.JSONObject;


public class CustomerServiceImpl implements CustomerService {

	static Logger logger = Logger.getLogger(CustomerServiceImpl.class.getName());

	@Autowired
	EhCache ehcache;
	
	@Override
	public JSONObject getCustomer(Long id) {
		Customer cus = new Customer();
		for (int i = 0; i < 5; i++) {
			cus = ehcache.loadCustomer(id);
			System.out.println("email: " + cus.getEmail());
		}
		JSONObject data = new JSONObject();
		data.put("data", cus.getEmail());
		return data;
	}
}
