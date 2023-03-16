package com.revature.TruckProducer;

import com.revature.models.TruckCoordinates;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;

import java.util.Properties;

public class TruckProducer {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.serializer", IntegerSerializer.class.getName());
		props.setProperty("value.serializer", TruckSerializer.class.getName());

		KafkaProducer<Integer, TruckCoordinates> producer = new KafkaProducer<>(props);
		
		TruckCoordinates tcs = new TruckCoordinates();
		tcs.setId(1);
		tcs.setLatitude("test latitude");
		tcs.setLongitude("test longitude");

		ProducerRecord<Integer, TruckCoordinates> record = new ProducerRecord<>("TruckCSLocations", tcs.getId(), tcs);

		try {
			producer.send(record, (metadata, ex) -> {
				System.out.println("Added: " + record.value() + "to topic: " + metadata.topic());
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}

	}

}
