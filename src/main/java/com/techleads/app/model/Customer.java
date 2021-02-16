package com.techleads.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@SequenceGenerator(name = "cust_seq", initialValue = 1, allocationSize = 1)
public class Customer {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
	private Integer customerId;
	private String customerName;
	private String customerEmail;

}
