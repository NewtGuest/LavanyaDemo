package com.vz.order.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@Table(name="orders")
public class Orders implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;

	@Column(name="created_date")
	private Date createdDate;

	@Column(name="modified_date")
	private Date modifiedDate;
	
	@Column(name="order_status")
	private String orderStatus;
	
	@Column(name="order_type")
	private String orderType;
	
	@Column(name="order_version")
	private int orderVersion;
	
	@Column(name="pro_version")
	private int proVersion;
	
	@Column(name="region")
	private String region;
	
	@Column(name="req_source")
	private String reqSource;

	public Orders() {
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public int getOrderVersion() {
		return this.orderVersion;
	}

	public void setOrderVersion(int orderVersion) {
		this.orderVersion = orderVersion;
	}

	public int getProVersion() {
		return this.proVersion;
	}

	public void setProVersion(int proVersion) {
		this.proVersion = proVersion;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getReqSource() {
		return this.reqSource;
	}

	public void setReqSource(String reqSource) {
		this.reqSource = reqSource;
	}

}