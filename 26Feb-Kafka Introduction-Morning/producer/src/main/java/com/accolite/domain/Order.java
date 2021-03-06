package com.accolite.domain;

public class Order {

	private int orderId;
	private String orderName;
	private String orderTaker;

	public Order() {

	}

	public Order(int orderId, String orderName, String orderTaker) {
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderTaker = orderTaker;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderTaker() {
		return orderTaker;
	}

	public void setOrderTaker(String orderTaker) {
		this.orderTaker = orderTaker;
	}

	@Override
	public String toString() {
		return "order [orderId=" + orderId + ", orderName=" + orderName + ", orderTaker=" + orderTaker + "]";
	}

	
}
