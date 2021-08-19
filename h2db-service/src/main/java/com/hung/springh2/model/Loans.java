package com.hung.springh2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loans")
public class Loans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private long start_date;

	@ManyToOne
	@JoinColumn(name ="customer_id")
	private Customer customer;
	
	@Column
	private long loan_type;
	
	@Column
	private long total_loan;
	
	@Column
	private long amount_paid;

	@Column
	private double outstanding_amount;
	
	@Column
	private long create_date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getStart_date() {
		return start_date;
	}

	public void setStart_date(long start_date) {
		this.start_date = start_date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getLoan_type() {
		return loan_type;
	}

	public void setLoan_type(long loan_type) {
		this.loan_type = loan_type;
	}

	public long getTotal_loan() {
		return total_loan;
	}

	public void setTotal_loan(long total_loan) {
		this.total_loan = total_loan;
	}

	public long getAmount_paid() {
		return amount_paid;
	}

	public void setAmount_paid(long amount_paid) {
		this.amount_paid = amount_paid;
	}

	public double getOutstanding_amount() {
		return outstanding_amount;
	}

	public void setOutstanding_amount(double outstanding_amount) {
		this.outstanding_amount = outstanding_amount;
	}

	public long getCreate_date() {
		return create_date;
	}

	public void setCreate_date(long create_date) {
		this.create_date = create_date;
	}
	
}
