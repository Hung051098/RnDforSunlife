package com.hung.springh2.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.hung.springh2.request.AddCustomerRequest;
import com.hung.springh2.request.AddUserRequest;

@Service
public interface CustomerService {

	JSONObject getListCustomer();

	JSONObject addCustomer(AddCustomerRequest request);

}
