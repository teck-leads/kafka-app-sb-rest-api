package com.techleads.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.techleads.app.common.KafkaConstants;
import com.techleads.app.model.Customer;
import com.techleads.app.repository.CustomerRepository;

@Service
public class CustomerService {

	static Logger logger = LoggerFactory.getLogger(CustomerService.class.getName());

	private KafkaTemplate<String, Customer> kafkaTemplate;

	private CustomerRepository customerRepository;

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Autowired
	public void setKafkaTemplate(KafkaTemplate<String, Customer> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public String addCustomer2Topic(List<Customer> customers) {

		try {
			if (!customers.isEmpty()) {
				for (Customer c : customers) {
					try {
						kafkaTemplate.send(KafkaConstants.TOPIC, c);
						logger.info("***********Message Published to Kafka topic************");
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Customer Record added to Kafka Queue successfully";
	}

	@KafkaListener(topics = KafkaConstants.TOPIC, groupId = KafkaConstants.GROUP_ID)
	public Customer listener(Customer c) {
		logger.info("***Message received from kafka topic:: " + c);
		customerRepository.save(c);
		return c;
	}

}
