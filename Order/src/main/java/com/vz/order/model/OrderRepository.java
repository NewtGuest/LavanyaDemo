package com.vz.order.model;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lavanyak
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
	
	List<Orders> findAll(Specification<Orders> order);
}
