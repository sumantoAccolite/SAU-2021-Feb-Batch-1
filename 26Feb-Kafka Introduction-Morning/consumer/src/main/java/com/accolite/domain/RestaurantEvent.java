package com.accolite.domain;

public class RestaurantEvent {

	private Integer restaurantEventId;
	private Order order;

	public Integer getRestaurantEventId() {
		return restaurantEventId;
	}

	public void setRestaurantEventId(Integer restaurantEventId) {
		this.restaurantEventId = restaurantEventId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "RestaurantEvent [restaurantEventId=" + restaurantEventId + ", order=" + order + "]";
	}	
	
}
