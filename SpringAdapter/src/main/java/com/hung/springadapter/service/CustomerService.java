package com.hung.springadapter.service;

import com.hung.springadapter.request.LoginRequest;
import com.ibm.json.java.JSONObject;

public interface CustomerService {

	public JSONObject getCustomer(String authTokenHeader);

	public JSONObject login(LoginRequest request);
}
