package com.xoriant.banking.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is Manager Model Class which is used as a data traveller between
 * different layers
 * 
 * @author Jangir_a
 *
 */
@Entity
@JsonIgnoreProperties("customers")
public class Manager extends PersonalInfo {
	/**
	 * customers field is use to store list of customers
	 */
	@OneToMany(mappedBy = "manager", cascade = CascadeType.PERSIST)
	private List<Customer> customers;

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}
