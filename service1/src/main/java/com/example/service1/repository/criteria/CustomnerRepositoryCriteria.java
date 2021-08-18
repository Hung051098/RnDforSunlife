package com.example.service1.repository.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.service1.model.Customer;


@Repository
public class CustomnerRepositoryCriteria {

    @PersistenceContext
    private EntityManager em;

    public List<Customer> getCustomer() {
    	CriteriaBuilder cb = em.getCriteriaBuilder();

    	CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
    	Root<Customer> root = query.from(Customer.class);// FROM User u
    	query.select(root);// SELECT
    	TypedQuery<Customer> typedQuery = em.createQuery(query);
    	List<Customer> results = typedQuery.getResultList();
    	return results;
    }

    public Customer getCustomerById(Integer id) {
    	CriteriaBuilder cb = em.getCriteriaBuilder();

    	CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
    	Root<Customer> root = query.from(Customer.class);// FROM User u
    	query.select(root);// SELECT
    	query.where(cb.equal(root.get("id"), id)); // WHERE u.id = :id
    	TypedQuery<Customer> typedQuery = em.createQuery(query);
    	Customer results = typedQuery.getSingleResult();
    	return results;
    }
}
