package com.vz.order.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import com.vz.order.model.Order;


public class OrderSpec implements Specification<Order> {
	
	final Order order;
	
	public OrderSpec(Order order) {
		this.order = order;
	}

	@Override
	public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> criteria = new ArrayList<Predicate>();
		if (order != null) {

			if (order.getOrderId() != 0) {
				criteria.add(cb.equal(root.get("orderId"), order.getOrderId()));
			}

			if (order.getOrderType() != null && !order.getOrderType().isEmpty()) {
				criteria.add(cb.equal(root.get("orderType"), order.getOrderType()));
			}
			
			if (order.getOrderStatus() != null && !order.getOrderStatus().isEmpty()) {
				criteria.add(cb.equal(root.get("orderStatus"), order.getOrderStatus()));
			}

			if (order.getOrderVersion() != 0) {
				criteria.add(cb.equal(root.get("orderVersion"), order.getOrderVersion()));
			}

			if (order.getProVersion() != 0) {
				criteria.add(cb.equal(root.get("proVersion"), order.getProVersion()));
			}
			
			if (order.getRegion() != null && !order.getRegion().isEmpty()) {
				criteria.add(cb.equal(root.get("region"), order.getRegion()));
			}
			
			if (order.getReqSource() != null && !order.getReqSource().isEmpty()) {
				criteria.add(cb.equal(root.get("reqSource"), order.getReqSource()));
			}
			
			if (order.getAddress1() != null && !order.getAddress1().isEmpty()) {
				criteria.add(cb.equal(root.get("address1"), order.getAddress1()));
			}
			
			if (order.getAddress2() != null && !order.getAddress2().isEmpty()) {
				criteria.add(cb.equal(root.get("address2"), order.getAddress2()));
			}
			
		}
		Predicate pred = null;

		if (criteria.size() == 1) {
			pred = criteria.get(0);
		} else if (criteria.size() > 1) {
			pred = cb.and(criteria.toArray(new Predicate[0]));
		}
		return pred;
	}

}
