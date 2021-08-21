package com.hung.springh2.dto.response;

public class LoansDTO {
	private Integer id;

	private long start_date;

	private long loan_type;
	
	private long total_loan;
	
	private long amount_paid;

	private double outstanding_amount;
	
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
