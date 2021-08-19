package com.hung.springh2.service;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.hung.springh2.request.AddUserRequest;

@Service
public interface LoansService {

	JSONObject getListLoansByCustomerId(int id);

	JSONObject addLoansByCustomerId(int id);

}
