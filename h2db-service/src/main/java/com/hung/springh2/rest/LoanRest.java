package com.hung.springh2.rest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hung.springh2.service.LoansService;

@RefreshScope
@RestController
@RequestMapping("/loans")
public class LoanRest {
	
	@Autowired
	LoansService loansService;

	@GetMapping("/add_loan_by_customer_id")
	public JSONObject addLoansByCustomerId(@RequestParam int id) {
		return loansService.addLoansByCustomerId(id);
	}

	@GetMapping("/list_loans_by_customer_id")
	public JSONObject getListLoansByCustomerId(@RequestParam int id) {
		return loansService.getListLoansByCustomerId(id);
	}
}
