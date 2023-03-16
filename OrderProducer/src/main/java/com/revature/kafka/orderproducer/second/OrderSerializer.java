package com.revature.kafka.orderproducer.second;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.kafka.models.Order;

import org.apache.kafka.common.serialization.Serializer;

public class OrderSerializer implements Serializer<Order>{

	@Override
	public byte[] serialize(String topic, Order order) {
		// initialize empty byte array for response
		byte[] response = null;
		// instantiate an object mapper from Jackson Databind library
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			// use object mapper to write your order object as a string and then convert to bytes
			response = objectMapper.writeValueAsString(order).getBytes();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return response;
	}

}
