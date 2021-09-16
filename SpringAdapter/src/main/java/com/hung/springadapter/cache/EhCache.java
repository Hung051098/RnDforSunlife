package com.hung.springadapter.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import com.hung.springadapter.data.Customer;
import com.hung.springadapter.ehcacheentities.EhCacheEntities;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCache {

	@Autowired
	CacheManager cacheManager;
	
	@Cacheable(value = "token")
	public EhCacheEntities loadToCache(Object obj, Object objAuthServer) {
		System.out.println("Loading to Ehcache .....");
		EhCacheEntities e = new EhCacheEntities();
		e.setTokenAuth(objAuthServer);
		e.setTokenMfp(obj);
		Cache cache = cacheManager.getCache("token");
		Cache cacheCustomer = cacheManager.getCache("customer");
		cache.put(new Element(obj, objAuthServer));
		Element element = cache.get(obj);
		System.out.println("===get_cache===: "+element.getValue());
		Element key1 = cacheCustomer.get("key1");
		System.out.println("===get_cache key1===: "+key1.getValue());
		return e;
	}


	public void putCustomerToCache() {
		System.out.println("Loading to Ehcache .....");
		Cache cache = cacheManager.getCache("customer");
		System.out.println("===cache===: "+ cache);
		cache.put(new Element("key1", "value1 sadwq"));
		Element element = cache.get("key1");
		System.out.println("===get_cache===: "+element.getValue());
//		Customer customer = new Customer();
//		customer.setCustomerId(1l);
//		customer.setFirstName("Lê");
//		customer.setLastName("Hùng");
//		customer.setEmail("hungglevan@gmail.com");
//		return customer;
	}
}
