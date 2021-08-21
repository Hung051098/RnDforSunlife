package com.hung.springh2.repository.criteria;

import com.hung.springh2.metamodel.Customer_;
import com.hung.springh2.model.Customer;
import org.springframework.data.jpa.domain.Specification;

public final class CustomerSpecification {
    public static Specification<Customer> hasId(Integer name) {
        return (root, query, cb) -> cb.equal(root.get(Customer_.ID), name);
    }
}
