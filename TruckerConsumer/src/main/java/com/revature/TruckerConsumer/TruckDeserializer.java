package com.revature.TruckerConsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.TruckCoordinates;

import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class TruckDeserializer implements Deserializer<TruckCoordinates> {

	@Override
	public TruckCoordinates deserialize(String topic, byte[] data) {
		TruckCoordinates tcs = null;
		
		ObjectMapper om = new ObjectMapper();
		
		try {
			tcs = om.readValue(data, TruckCoordinates.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return tcs;
	}

}
