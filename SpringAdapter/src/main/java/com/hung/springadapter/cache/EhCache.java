package com.hung.springadapter.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;

import com.hung.springadapter.data.Customer;
import com.hung.springadapter.ehcacheentities.EhCacheEntities;
import com.ibm.json.java.JSONObject;

public class EhCache {

	@Autowired
	CacheManager cacheManager;

	@Cacheable(value = "customer")
	public Customer loadCustomer() {
		System.out.println("Loading to Ehcache .....");
		Customer customer = new Customer();
		customer.setCustomerId(1l);
		customer.setFirstName("Lê");
		customer.setLastName("Hùng");
		customer.setEmail("hungglevan@gmail.com");
		return customer;
	}

	@Cacheable(value = "token")
	public EhCacheEntities loadToCache(Object obj, Object objAuthServer) {
		System.out.println("Loading to Ehcache .....");
		EhCacheEntities e = new EhCacheEntities();
		e.setTokenAuth(objAuthServer);
		e.setTokenMfp(obj);
		return e;
	}
}
