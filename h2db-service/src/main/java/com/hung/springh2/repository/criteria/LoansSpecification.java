package com.hung.springh2.repository.criteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.hung.springh2.model.Customer;
import com.hung.springh2.model.Customer_;
import com.hung.springh2.model.Loans;
import com.hung.springh2.model.Loans_;

public final class LoansSpecification {
    
    public static Specification<Loans> joinTable(int id) {
		return new Specification<Loans>(){
			@Override
			public Predicate toPredicate(Root<Loans> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) {
				Join<Loans, Customer> croot = root.join(Loans_.CUSTOMER);

				System.out.println("b");
				Predicate equalPredicate = criteriaBuilder.equal(croot.get(Customer_.ID), id);
				return equalPredicate;
			}
		};
	}
}
