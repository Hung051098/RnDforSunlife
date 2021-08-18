package com.hung.springh2.request;

import javax.persistence.Column;

import com.hung.springh2.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {
	private String email;

	private String role;

	private String pwd;

	private String name;

	private String mobile_number;
	
	private String create_dt;
}
