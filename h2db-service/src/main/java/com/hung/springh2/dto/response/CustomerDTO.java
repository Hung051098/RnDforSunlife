package com.hung.springh2.dto.response;

import java.util.Collection;

import com.hung.springh2.model.Loans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CustomerDTO {
	private Integer id;

	private String email;

	private String role;

	private String pwd;

	private String name;

	private String mobile_number;

	private long create_dt;

	private Collection<LoansDTO> loans;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public long getCreate_dt() {
		return create_dt;
	}

	public void setCreate_dt(long create_dt) {
		this.create_dt = create_dt;
	}

	public Collection<LoansDTO> getLoans() {
		return loans;
	}

	public void setLoans(Collection<LoansDTO> loans) {
		this.loans = loans;
	}
	
	
}
