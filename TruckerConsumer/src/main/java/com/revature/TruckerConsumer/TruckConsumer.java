package com.revature.TruckerConsumer;

import com.revature.models.TruckCoordinates;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class TruckConsumer {

	public static void main(String[] args) {
		
		
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.deserializer", IntegerDeserializer.class.getName());
		props.setProperty("value.deserializer", TruckDeserializer.class.getName());
		props.setProperty("group.id", "TruckLocations");
		
		KafkaConsumer<Integer, TruckCoordinates> consumer = new KafkaConsumer<>(props);
		
		consumer.subscribe(Collections.singletonList("TruckCSLocations"));
		
		ConsumerRecords<Integer, TruckCoordinates> records = consumer.poll(Duration.ofSeconds(10));

		for (ConsumerRecord<Integer, TruckCoordinates> record: records) {
			int id = record.key();
			TruckCoordinates cds = record.value();
			System.out.println("Truck Id: " + id);
			System.out.println("Truck Latitude: " + cds.getLatitude());
			System.out.println("Truck Longitude: " + cds.getLongitude());
		}
		
		consumer.close();
		
	}
	
	
}
