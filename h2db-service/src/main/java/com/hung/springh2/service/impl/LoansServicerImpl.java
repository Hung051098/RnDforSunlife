package com.hung.springh2.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.hung.springh2.model.Customer;
import com.hung.springh2.model.Loans;
import com.hung.springh2.repository.CustomerRepository;
import com.hung.springh2.repository.LoansRepository;
import com.hung.springh2.repository.criteria.CustomerRepositoryCriteria;
import com.hung.springh2.repository.criteria.LoansReponsitoryCriteria;
import com.hung.springh2.service.LoansService;
import com.hung.springh2.util.ConvertUtils;

@Service
public class LoansServicerImpl implements LoansService {

	@Autowired
	LoansReponsitoryCriteria loansReponsitoryCriteria;
	
	@Autowired
	CustomerRepositoryCriteria customerRepositoryCriteria;

	@Autowired
	LoansRepository loansReponsitory;
	
	@Autowired
	CustomerRepository customerReponsitory;
	
	@Override
	public JSONObject addLoansByCustomerId(int id) {
		JSONObject data = new JSONObject();
		try {
			Customer cus = customerRepositoryCriteria.getCustomerById(id);
			Loans loans = new Loans();
			loans.setCreate_date(new Date().getTime());
			loans.setCustomer(cus);
			loans.setLoan_type(500000);
			loans.setOutstanding_amount(50000);
			loans.setStart_date(50000);
			loans.setTotal_loan(10000);
			loans.setAmount_paid(10000);
			loans = loansReponsitory.save(loans);
			data.put("data", "success");
			return data;
		} catch (Exception e) {
			System.out.println(e);
		}
		return data;
	}

	@Override
	public JSONObject getListLoansByCustomerId(int id) {

		JSONObject data = new JSONObject();
		try {
//			List<Loans> lst = loansReponsitoryCriteria.getListLoanByCustomerId(id);
//			Specification<Loans> specification = Specification.where(LoansSpecification.joinTable(id));
			
			List<Customer> lst = customerReponsitory.findAll();
			
			List<JSONObject> lstcon = new ArrayList<>();
			for (Customer customer : lst) {

				JSONObject con = new JSONObject();
				con.put("id", customer.getId());
				con.put("size", customer.getLoans().size());
				lstcon.add(con);
			}
			data.put("data", lstcon);
			return data;
		} catch (Exception e) {
			System.out.println(e);
		}
		return data;
	}

	@Override
	public JSONObject countLoansByCustomerId(int id) {

		JSONObject data = new JSONObject();
		try {
			List<Object[]> multiselect = loansReponsitoryCriteria.countSelect(id);
			double count = 0d;
			double avg = 0d;
			for (Object[] objects : multiselect) {
				System.out.println(new Gson().toJson(objects));
				count =  ConvertUtils.toDouble(objects[0]);
				avg =  ConvertUtils.toDouble(objects[1]);
			}
			data.put("count", count);
			data.put("avg", avg);
			return data;
		} catch (Exception e) {
			System.out.println(e);
		}
		return data;
	}
}
