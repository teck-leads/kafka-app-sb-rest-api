package com.techleads.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.Customer;
import com.techleads.app.service.CustomerService;

@RestController
public class CustomerController {
	
	
	private CustomerService customerService;
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	@PostMapping(value = "/customer/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
	public String addCustomer(@RequestBody List<Customer> customers) {
		return customerService.addCustomer2Topic(customers);
	}
	
	
	
	

}
