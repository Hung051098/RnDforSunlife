package com.hung.springh2.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "customer")

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@Column
	private String email;

	@Column
	private String role;

	@Column
	private String pwd;

	@Column
	private String name;

	@Column
	private String mobile_number;

	@Column
	private long create_dt;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@Fetch(FetchMode.SUBSELECT)
	private Collection<Loans> loans;
	
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

	public Collection<Loans> getLoans() {
		return loans;
	}

	public void setLoans(Collection<Loans> loans) {
		this.loans = loans;
	}

}
