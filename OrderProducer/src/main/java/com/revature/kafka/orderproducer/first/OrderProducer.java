package com.revature.kafka.orderproducer.first;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class OrderProducer {
	
	// N.B. You must have already started your zookeeper and broker!!

	public static void main(String[] args) {

		// Create new properties
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.IntegerSerializer");

		// now we can create a new Kafka Producer
		KafkaProducer<String, Integer> producer = new KafkaProducer<String, Integer>(props); // this is a resource that
																								// needs to be closed

		ProducerRecord<String, Integer> record = new ProducerRecord<>("OrderTopic", "Mac Mini", 10);

		try {

			// RecordMetadata recordMetadata = producer.send(record).get(); // this is a
			// synchronous call as it stands now (we are waiting for the future to resolve)
			// System.out.println(recordMetadata.partition());
			// System.out.println(recordMetadata.offset());

			// for async use callback
			// producer.send(record, new OrderCallback()); // clunky - we can do it inline
			// with an anonymous class or in external class
			// important thing here is that it implements the onCompletetion method from the
			// Callback Functional Interface defined by Kafka

//			producer.send(record, new Callback() {
//
//				@Override
//				public void onCompletion(RecordMetadata metadata, Exception exception) {
//					System.out.println(metadata.partition());
//					System.out.println(metadata.offset());
//					System.out.println("Message sent successfully!");
//					
//					if (exception != null) {
//						exception.printStackTrace();
//					}
//					
//				}
//				
//			});

			// or with lambdas!
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
