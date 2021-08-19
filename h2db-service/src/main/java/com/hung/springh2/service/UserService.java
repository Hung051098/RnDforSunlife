package com.hung.springh2.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.hung.springh2.request.AddUserRequest;

@Service
public interface UserService {

	JSONObject getListUser();

	JSONObject addCustomer(AddUserRequest request);

}
