package com.hung.springh2.repository.criteria;

import com.hung.springh2.metamodel.Customer_;
import com.hung.springh2.metamodel.Loans_;
import com.hung.springh2.model.Customer;
import com.hung.springh2.model.Loans;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public final class CustomerSpecification {
    public static Specification<Customer> hasId(Integer name) {
        return (root, query, cb) -> cb.equal(root.get(Customer_.ID), name);
    }
    
    public static Specification<Customer> joinTable() {
		return new Specification<Customer>(){
			@Override
			public Predicate toPredicate(Root<Customer> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) {
				Join<Customer, Loans> loanJoin = root.join(Customer_.LOANS);

				System.out.println("b");
				Predicate equalPredicate = criteriaBuilder.equal(root.get(Customer_.ID), loanJoin.get(Loans_.CUSTOMER));
				return equalPredicate;
			}
		};
	}
}