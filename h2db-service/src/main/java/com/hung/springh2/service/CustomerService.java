package com.hung.springh2.service;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.hung.springh2.dto.response.CustomerDTO;
import com.hung.springh2.dto.response.CustomerDetailDTO;
import com.hung.springh2.request.AddCustomerRequest;

@Service
public interface CustomerService {

	List<CustomerDTO> getListCustomer();

	JSONObject addCustomer(AddCustomerRequest request);

	JSONObject getCustomerById(int id);

	JSONObject getListCustomerByFilter(String key_filter, String value_filter);

	JSONObject updateCustomerById(int id, AddCustomerRequest request);

	JSONObject deleteById(Integer id);

	CustomerDetailDTO getCustomerDetail(int id);

}
