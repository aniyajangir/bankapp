package com.xoriant.banking.command;

import com.xoriant.banking.model.AccountType;

import com.xoriant.banking.model.Status;

/**
 * AddAccountCommand is command to add account
 * 
 * @author Jangir_a
 *
 */

public class AccountDTO {
	private String selectedProperty;
	private int personId;
	private double balance;
	private Status status;
	private AccountType accountType;
	private double minBalance;
	private Long accountNo;

	public String getSelectedProperty() {
		return selectedProperty;
	}

	public void setSelectedProperty(String selectedProperty) {
		this.selectedProperty = selectedProperty;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

}