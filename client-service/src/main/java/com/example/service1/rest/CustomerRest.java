package com.example.service1.rest;

import java.util.Collections;
import java.util.Date;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.service1.model.Address;
import com.example.service1.model.Customer;
import com.example.service1.model.Loans;
import com.example.service1.model.Person;
import com.example.service1.repository.AddressRepository;
import com.example.service1.repository.CustomerRepository;
import com.example.service1.repository.LoansRepository;
import com.example.service1.repository.PersonRepository;
import com.example.service1.service.CustomerService;

@RestController
@RequestMapping("/customer")
@RequestScope
public class CustomerRest {
	@Value("${sample.example}")
	String example;

	@Autowired
	CustomerService customerService;
	@Autowired
    private LoansRepository loansReponsitory;
	@Autowired
    private PersonRepository personRepository;
	@Autowired
    private CustomerRepository customerRepository;
	@Autowired
    private AddressRepository addressRepository;

	@RequestMapping("/list_customer")
	public JSONObject getListCustomer() {
		return customerService.getListCustomer();
	}

	@RequestMapping("/get_customer_by_id")
	public JSONObject getCustomerById(@RequestParam int id ) {
		return customerService.getCustomerById(id);
	}

	@RequestMapping("/getconfig")
	public String getconfig( ) {
		Address address = new Address();
        address.setCity("Hanoi");

        // Tạo ra đối tượng person
        Person person = new Person();
        person.setName("loda");
        person.setAddress(address);

        address.setPersons(Collections.singleton(person));
        // Lưu vào db
        // Chúng ta chỉ cần lưu address, vì cascade = CascadeType.ALL nên nó sẽ lưu luôn Person.
        addressRepository.saveAndFlush(address);
		return example;
	}

	@RequestMapping("/add_customer")
	public String getconfig_customer( ) {

        Customer cus = new Customer();
        cus.setEmail("aaa");
        cus.setMobile_number("aaaaa");
        cus.setName("hung");
        cus.setPwd("123456");
        cus.setRole("admin");
        customerRepository.save(cus);
		Loans loans = new Loans();
		loans.setCreate_date(new Date().getTime());
		loans.setLoan_type(500000);
		loans.setOutstanding_amount(50000);
		loans.setStart_date(50000);
		loans.setTotal_loan(10000);
		loans.setAmount_paid(10000);
		loans.setCustomer(cus);
		cus.setLoans(Collections.singleton(loans));
		loansReponsitory.saveAndFlush(loans);

        // Tạo ra đối tượng person
//        Person person = new Person();
//        person.setName("loda");
//        person.setAddress(address);
//
//        address.setPersons(Collections.singleton(person));
//        // Lưu vào db
//        // Chúng ta chỉ cần lưu address, vì cascade = CascadeType.ALL nên nó sẽ lưu luôn Person.
//        addressRepository.saveAndFlush(address);
		return example;
	}
}
