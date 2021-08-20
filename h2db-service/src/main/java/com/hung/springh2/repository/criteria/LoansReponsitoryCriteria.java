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

import org.hibernate.query.Query;
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
		/** chú ý:
		 * lroot.get("customer") trong đó customer là tên biến của lớp Loans; 
		 * croot.get("id") trong đó customer là tên biến của lớp Customer; 
		 */
		Join<Loans, Customer> croot = lroot.join("customer");
		Predicate p2 = cb.equal(lroot.get("customer"), id);
		query.select(lroot)
		.where(p2);
		TypedQuery<Loans> typedQuery = em.createQuery(query); // query 
    	List<Loans> results = typedQuery.getResultList(); // trả về kết quả 
    	return results;
	}
	
	public List<Loans> getListLoanByCustomerId2(int id) {
		int pageSize = 2;
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Loans> criteriaQuery = criteriaBuilder
		  .createQuery(Loans.class);
		Root<Loans> from = criteriaQuery.from(Loans.class);
		CriteriaQuery<Loans> select = criteriaQuery.select(from);
		TypedQuery<Loans> typedQuery = em.createQuery(select);
		typedQuery.setFirstResult(0);
		typedQuery.setMaxResults(pageSize);
		
		List<Loans> loansList = typedQuery.getResultList();
		return loansList;
	}

	public List<Object[]> countSelect(int id) {
		CriteriaBuilder cb  = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
		Root<Loans> lroot = query.from(Loans.class);
		query.multiselect(
				cb.count(lroot.get("total_loan")), 
				cb.avg(lroot.get("total_loan")));

		Predicate p2 = cb.equal(lroot.get("customer"), id);
		
		query.where(p2); 
		
		
		TypedQuery<Object[]> typedQuery = em.createQuery(query); // query 
		List<Object[]> obj = typedQuery.getResultList();
		return obj;
	}
}
