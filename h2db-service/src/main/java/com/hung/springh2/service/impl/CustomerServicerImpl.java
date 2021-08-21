package com.hung.springh2.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.hung.springh2.dto.mapper.CustomerMapper;
import com.hung.springh2.dto.response.CustomerDTO;
import com.hung.springh2.model.Customer;
import com.hung.springh2.repository.CustomerRepository;
import com.hung.springh2.repository.criteria.CustomerRepositoryCriteria;
import com.hung.springh2.repository.criteria.CustomerSpecification;
import com.hung.springh2.request.AddCustomerRequest;
import com.hung.springh2.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomerServicerImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CustomerRepositoryCriteria customerRepositoryCriteria;

	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<CustomerDTO> getListCustomer() {
		// TODO Auto-generated method stub
		JSONObject data = new JSONObject();
		List<Customer> lst = customerRepository.findAll();
		List<CustomerDTO> lstCustomer = new ArrayList<>();
		for (Customer cus : lst) {
			
			CustomerDTO dtoMap = customerMapper.mapperCustomer(cus);
			lstCustomer.add(dtoMap);
		}
		System.out.println("a");
		data.put("data", lstCustomer);
		return lstCustomer;
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
//		Customer custt = customerRepositoryCriteria.getCustomerById(id);
		Specification<Customer> specification = Specification.where(CustomerSpecification.hasId(id));
		Optional<Customer> cus = customerRepository.findOne(CustomerSpecification.hasId(id));
		Customer custt = cus.get();
		data.put("id", custt.getId());
		data.put("name", custt.getName());
		data.put("email", custt.getEmail());
		data.put("role", custt.getRole());
		return data;
	}

	@Override
	public JSONObject getListCustomerByFilter(String key_filter, String value_filter) {
		JSONObject data = new JSONObject();
		List<JSONObject> lstCustomer = new ArrayList<>();
		List<Customer> lst = customerRepositoryCriteria.getListCustomerFilter(key_filter, value_filter);
		for (Customer cus : lst) {

			JSONObject customer = new JSONObject();
			customer.put("id", cus.getId());
			customer.put("name", cus.getName());
			customer.put("email", cus.getEmail());
			customer.put("role", cus.getRole());
			lstCustomer.add(customer);
		}
		data.put("data", lstCustomer);
		return data;
	}
	
	@Override
	public JSONObject updateCustomerById(int id, AddCustomerRequest request) {
		JSONObject data = new JSONObject();
		Customer customer = customerRepositoryCriteria.getCustomerById(id);
		customer.setName(request.getName());
		customer.setCreate_dt(new Date().getTime());
		customer.setEmail(request.getEmail());
		customer.setMobile_number(request.getMobile_number());
		customer.setPwd(request.getPwd());
		customer.setRole(request.getRole());
		customer = customerRepository.save(customer);
		data.put("data", "success");
		return data;
	}
	
	@Override
	public JSONObject deleteById(Integer id) {
		JSONObject data = new JSONObject();
		customerRepository.deleteById(id);
		data.put("data", "success");
		return data;
	}
}
