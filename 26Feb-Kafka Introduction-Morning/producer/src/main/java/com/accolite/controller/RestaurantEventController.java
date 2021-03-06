package com.accolite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.domain.RestaurantEvent;
import com.accolite.producer.RestaurantEventProducer;
import com.fasterxml.jackson.core.JsonProcessingException;


@RestController
public class RestaurantEventController {
	
	@Autowired
	private RestaurantEventProducer restaurantEventProducer;
	
	@PostMapping("/v1/restaurantEvent")
	public ResponseEntity<RestaurantEvent> postrestaurantEvent(@RequestBody RestaurantEvent restaurantEvent)
			throws JsonProcessingException {

		restaurantEventProducer.sendRestaurantEventAsynchronous(restaurantEvent);

		return ResponseEntity.status(HttpStatus.CREATED).body(restaurantEvent);
	}
	

}
