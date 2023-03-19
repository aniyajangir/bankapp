package com.xoriant.banking.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is Customer Model Class which is used as a data traveller between
 * different layers
 * 
 * @author Jangir_a
 *
 */
@Entity
@JsonIgnoreProperties("accounts")
public class Customer extends PersonalInfo {
	/**
	 * managerId field is use to uniquely indentify manager
	 */
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "managerId")
	private Manager manager;
	/**
	 * accounts field is use to store list of accounts
	 */
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
	private List<Account> accounts;
	/**
	 * customerStatus is use to store status of customer ACTIVE or INACTIVE
	 */
	@Enumerated(EnumType.STRING)
	private Status customerStatus;

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Status getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(Status customerStatus) {
		this.customerStatus = customerStatus;
	}

	
}
