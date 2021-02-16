package com.techleads.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.techleads.app.repository.CustomerRepository;
@EnableJpaRepositories(basePackageClasses = CustomerRepository.class)
@SpringBootApplication
public class KafkaAppsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaAppsApplication.class, args);
	}

}
