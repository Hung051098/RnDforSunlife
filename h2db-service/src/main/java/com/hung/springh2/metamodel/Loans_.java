package com.hung.springh2.metamodel;

import com.hung.springh2.model.Customer;
import com.hung.springh2.model.Loans;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Loans.class)
public class Loans_ {
    public static volatile SingularAttribute<Loans, Integer> id;
    public static volatile SingularAttribute<Loans, String> start_date;
    public static volatile SingularAttribute<Loans, String> customer;
    public static volatile SingularAttribute<Loans, String> loan_type;
    public static volatile SingularAttribute<Loans, String> total_loan;
    public static volatile SingularAttribute<Loans, String> amount_paid;
    public static volatile SingularAttribute<Loans, String> outstanding_amount;
    public static volatile SetAttribute<Loans, String> create_date;
    
    public static final String ID = "id";
    public static final String START_DATE = "start_date";
    public static final String CUSTOMER = "customer";
    public static final String LOAN_TYPE = "loan_type";


}