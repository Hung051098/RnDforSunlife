package com.hung.springadapter.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;

import com.hung.springadapter.data.Customer;

public class EhCache {

	@Autowired
	CacheManager cacheManager;

	@Cacheable(value = "customer")
	public Customer loadCustomer(Long id) {
		System.out.println("cacheName: " + cacheManager.getCacheNames());
		System.out.println("hungggggggggg");
		Customer customer = new Customer();
		customer.setCustomerId(id);
		customer.setFirstName("Test");
		customer.setLastName("User");
		customer.setEmail("contact-us@javadevjournlal.com");
		return customer;
	}
}
