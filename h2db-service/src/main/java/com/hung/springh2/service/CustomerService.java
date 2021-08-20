package com.hung.springh2.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.hung.springh2.request.AddCustomerRequest;
import com.hung.springh2.request.AddUserRequest;

@Service
public interface CustomerService {

	JSONObject getListCustomer();

	JSONObject addCustomer(AddCustomerRequest request);

	JSONObject getCustomerById(int id);

	JSONObject getListCustomerByFilter(String key_filter, String value_filter);

	JSONObject updateCustomerById(int id, AddCustomerRequest request);

	JSONObject deleteById(Integer id);

}
