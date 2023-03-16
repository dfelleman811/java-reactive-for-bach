package com.revature.TruckProducer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.TruckCoordinates;

import org.apache.kafka.common.serialization.Serializer;

public class TruckSerializer implements Serializer<TruckCoordinates> {

	@Override
	public byte[] serialize(String topic, TruckCoordinates coordinates) {

		byte[] response = null;
		
		ObjectMapper om = new ObjectMapper();
		
		try {
			response = om.writeValueAsString(coordinates).getBytes();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return response;
	}

}
