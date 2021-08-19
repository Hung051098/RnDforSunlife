package com.hung.springh2.repository.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.hung.springh2.model.Customer;

@Repository
public class CustomerRepositoryCriteria {
	@PersistenceContext
    private EntityManager em;

    public List<Customer> getCustomer() {
    	CriteriaBuilder cb = em.getCriteriaBuilder();

    	CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
    	Root<Customer> root = query.from(Customer.class);// FROM User u
    	query.select(root);// SELECT
    	TypedQuery<Customer> typedQuery = em.createQuery(query);// query 
    	List<Customer> results = typedQuery.getResultList(); // trả về kết quả
    	return results;
    }

    public Customer getCustomerById(Integer id) {
    	CriteriaBuilder cb = em.getCriteriaBuilder();

    	CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
    	Root<Customer> root = query.from(Customer.class);// FROM Customer u
    	query.select(root);// SELECT
    	query.where(cb.equal(root.get("id"), id)); // WHERE u.id = :id
    	TypedQuery<Customer> typedQuery = em.createQuery(query); // query 
    	Customer results = typedQuery.getSingleResult(); // trả về kết quả 
    	return results;
    }


    public List<Customer> getListCustomerFilter(String key_filter, String value_filer) {
    	CriteriaBuilder cb = em.getCriteriaBuilder();

    	CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
    	Root<Customer> root = query.from(Customer.class);// FROM Customer c
    	query.select(root);// SELECT
    	Predicate p1 = cb.like(root.get(key_filter), "%"+value_filer+"%");// WHERE key_filter like :value_filer
//    	query.where(cb.equal(root.get(key_filter), value_filer)); // WHERE key_filter = :value_filer
    	query.where(p1);
    	TypedQuery<Customer> typedQuery = em.createQuery(query); // query 
    	List<Customer> results = typedQuery.getResultList(); // trả về kết quả 
    	return results;
    }
}
