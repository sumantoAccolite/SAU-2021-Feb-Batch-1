package com.accolite.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.accolite.domain.RestaurantEvent;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class RestaurantEventProducer {

	@Autowired
	private KafkaTemplate<String, RestaurantEvent> kafkaTemplate;

	public void sendRestaurantEventAsynchronous(RestaurantEvent restaurantEvent) throws JsonProcessingException {
		kafkaTemplate.send("test-topic", restaurantEvent);
	}

}
