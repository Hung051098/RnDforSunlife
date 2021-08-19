package com.hung.springh2.repository.criteria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.hung.springh2.model.Customer;
import com.hung.springh2.model.Loans;

@Repository
public class LoansReponsitoryCriteria {
	@PersistenceContext
	private EntityManager em;
	
	public List<Loans> getListLoanByCustomerId(int id) {
		CriteriaBuilder cb  = em.getCriteriaBuilder();
		CriteriaQuery<Loans> query = cb.createQuery(Loans.class);
		Root<Loans> lroot = query.from(Loans.class);
		Join<Loans, Customer> croot = lroot.join("customer");
		/** chú ý:
		 * lroot.get("customer") trong đó customer là tên biến của lớp Loans; 
		 * croot.get("id") trong đó customer là tên biến của lớp Customer; 
		 */
		Predicate p1 = cb.equal(croot.get("id"), lroot.get("customer"));
		Predicate p2 = cb.equal(lroot.get("customer"), id);
		query.select(lroot)
		.where(p1, p2);
		TypedQuery<Loans> typedQuery = em.createQuery(query); // query 
    	List<Loans> results = typedQuery.getResultList(); // trả về kết quả 
    	return results;
	}
}
