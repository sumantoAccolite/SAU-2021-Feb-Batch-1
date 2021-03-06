package com.accolite.deserializer;

import org.apache.kafka.common.serialization.Deserializer;

import com.accolite.domain.RestaurantEvent;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestaurantEventDeserializer implements Deserializer<RestaurantEvent>{

	@Override
	public RestaurantEvent deserialize(String topic, byte[] data) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

		RestaurantEvent msg = null;
		try {
			msg = objectMapper.readValue(data, RestaurantEvent.class);
		} catch (Exception e) {
			System.out.println("Exception while reading value"+e);
		}

		return msg;
	}

}
