package com.example.service1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Person {
	@Id
    @GeneratedValue
    private Integer id;
    private String name;

    // Many to One Có nhiều người ở 1 địa điểm.
    @ManyToOne 
    @JoinColumn(name = "address_id") // thông qua khóa ngoại address_id
    private Address address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
    public Person() {
		// TODO Auto-generated constructor stub
	}
}
