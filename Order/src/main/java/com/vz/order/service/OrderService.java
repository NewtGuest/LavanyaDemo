package com.vz.order.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vz.order.constants.StatusCode;
import com.vz.order.exception.ApplicationException;
import com.vz.order.model.Order;
import com.vz.order.model.OrderRepository;

@Service
public class OrderService {
	
	private static final Logger LOGGER = Logger.getLogger(OrderService.class);
	
	@Autowired
	OrderRepository orderRepository;
	
	public List<Order> getOrders(Order order)
			throws ApplicationException {
		List<Order> orderList = null;
		try {
			orderList = orderRepository.findAll(new OrderSpec(order));
		} catch (Exception e) {
			LOGGER.error("Get Order : Exception : " + e);
			throw new ApplicationException(StatusCode.APP_ERROR.getCode(),
					"Application Error. Not able to Get Order Details");
		}
		return orderList;
	}
	
	public Order createOrder(Order order) {
		Order createdOrder = new Order();
		order.setCreatedDate(new Date());
		order.setModifiedDate(new Date());
		createdOrder = orderRepository.save(order);
		return createdOrder;
	}
}
