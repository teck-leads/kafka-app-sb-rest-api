package com.techleads.app.runner;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class ProducerRunner implements CommandLineRunner {

//	String BOOTSTRAP_SERVERS = "127.0.0.1:9092";
	String BOOTSTRAP_SERVERS = "localhost:9092";
	Logger logger= LoggerFactory.getLogger(this.getClass());

	@Override
	public void run(String... args) throws Exception {

//		String TOPIC = "First_Topic";
		String TOPIC="test";
		logger.info("sending data from producer to topic");
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		//Producer instance
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);
		
		
		for(int i=0;i<10;i++) {
			// create a Producer Record
			ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC, "Message: "+i+" from producer 11FEB");
			//send data asynchronous
			producer.send(record);
		}
		// flush data
		producer.flush();
		// flush and close producer
		logger.info("Data sent to topic");
		producer.close();
	}

}
