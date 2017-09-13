package com.vz.order.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.vz.order.constants.StatusCode;
import com.vz.order.exception.ApplicationException;
import com.vz.order.model.Order;
import com.vz.order.model.OrderResponse;
import com.vz.order.model.ResponseStatus;
import com.vz.order.service.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {
	/**
     * Logger
     */
    private static final Logger LOGGER = Logger.getLogger(OrderController.class);
    
    @Autowired
    private OrderService orderService;
    
    /**
     * Get OrderRequestFallout
     * 
     * @param order
     * @return
     */
    @RequestMapping(value = "/getOrders", method = RequestMethod.POST)
    @CrossOrigin(origins = { "*" })
	@ApiOperation(value = "Get Order", notes = "Returns A Response Of Order Details. SLA:500", response = OrderResponse.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Retrieved OrderRequestFallout Details", response = Order.class),
			@ApiResponse(code = 400, message = "Invalid Input Provided"),
			@ApiResponse(code = 404, message = "Note Does Not Exist") })
	public ResponseEntity<OrderResponse> getOrderRequestFallout(@RequestBody Order order) {
    	OrderResponse response = new OrderResponse();
    	Boolean returnStatus = false;
		String statusCode = null;
		String statusMsg = null;
		List<Order> orderList = null;
		
    	try {
			orderList = orderService.getOrders(order);
			if (orderList != null && !orderList.isEmpty()) {
				statusMsg = StatusCode.SUCCESS.getDesc();
				statusCode = StatusCode.SUCCESS.getCode();

			} else {
				statusMsg = StatusCode.DATA_NOT_FOUND.getDesc();
				statusCode = StatusCode.DATA_NOT_FOUND.getCode();
			}
			
		} catch (ApplicationException e) {
			statusMsg = e.getMessage();
			statusCode = e.getErrCode();
			e.printStackTrace();
		}
    	ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setCode(statusCode);
		responseStatus.setDescription(statusMsg);
		
		response.setStatus(responseStatus);
		response.setOrderList(orderList);

		if (returnStatus) {
			LOGGER.debug(" OrderRequestFallout retrieved successfully");
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
		}
    }
    
    
    /**
     * Create OrderRequestFallout
     * 
     * @param orderRequest
     * @return
     */
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin(origins = { "*" })
    @ApiOperation(value = "Create Order", notes = "Returns a response of Order creation. SLA:500", response = OrderResponse.class)
    @ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successful Creation Of Order", response = OrderResponse.class),
	    @ApiResponse(code = 404, message = "Creation Of Order Failed"),
	    @ApiResponse(code = 400, message = "Invalid Input Provided") })
    public ResponseEntity<OrderResponse> createOrderRequestFallout(@RequestBody Order orderRequest) {
    	
    	OrderResponse response = new OrderResponse();
    	Order order = new Order();
    	Boolean returnCreateStatus = false;
		String createStatusCode = null;
		String createstatusMsg = null;
		boolean isValid = false;
    	
    	order = orderService.createOrder(orderRequest);
		returnCreateStatus = true;
		if (order != null) {
			createStatusCode = StatusCode.SUCCESS.getCode();
			createstatusMsg = StatusCode.SUCCESS.getDesc();

		} else {
			createStatusCode = StatusCode.DATA_NOT_FOUND.getCode();
			createstatusMsg = StatusCode.DATA_NOT_FOUND.getDesc();
		}
    	ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setCode(createStatusCode);
		responseStatus.setDescription(createstatusMsg);
		response.setStatus(responseStatus);
		
    	if (returnCreateStatus) {
    		response.setOrder(order);
    		LOGGER.debug("Order created successfully");
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
		}
    }
}
