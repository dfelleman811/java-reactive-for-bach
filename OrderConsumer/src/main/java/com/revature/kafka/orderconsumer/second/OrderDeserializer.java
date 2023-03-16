package com.revature.kafka.orderconsumer.second;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.kafka.models.Order;

import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class OrderDeserializer implements Deserializer<Order> {

	@Override
	public Order deserialize(String topic, byte[] data) {
		// Order to return
		Order order = null;
		
		// deserialize
		try {
			order = new ObjectMapper().readValue(data, Order.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return order;
	}

}
