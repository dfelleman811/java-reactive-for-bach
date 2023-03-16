package com.revature.kafka.orderproducer.second;

import com.revature.kafka.models.Order;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class OrderProducer {
	
	// N.B. You must have already started your zookeeper and broker!!

	public static void main(String[] args) {

		// Create new properties
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,	OrderSerializer.class.getName());

		// now we can create a new Kafka Producer
		KafkaProducer<String, Order> producer = new KafkaProducer<String, Order>(props); 
		
		Order order = new Order();
		order.setCustomerName("Dan");
		order.setProduct("iPhone");
		order.setQuantity(1);
		
		ProducerRecord<String, Order> record = new ProducerRecord<>("OrderCSTopic", order.getCustomerName(), order);

		try {
			producer.send(record, (metadata, exception) -> {
				System.out.println(metadata.partition());
				System.out.println(metadata.offset());
				System.out.println("Message sent!");
				if (exception != null)
					exception.printStackTrace();
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}

	}

}
