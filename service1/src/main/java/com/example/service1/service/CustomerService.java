package com.example.service1.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

	JSONObject getListCustomer();

	JSONObject getCustomerById(int id);

}
