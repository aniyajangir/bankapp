package com.xoriant.banking.model;

import javax.persistence.JoinColumn;


import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * This is Transactions Model Class which is used as a data traveller between
 * different layers
 * 
 * @author Jangir_a
 *
 */
@Entity
public class Transactions {
	/**
	 * transactionId field is use to uniquely indentify transactions
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	/**
	 * fromAccount is use to store account details from which amount is sent
	 */
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fromAccountNumber")
	private Account fromAccount;

	/**
	 * fromAccount is use to store account details to which amount is sent
	 */
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "toAccountNumber")
	private Account toAccount;

	private double amount;

	/**
	 * dateOfTransaction is use to store dateOfTransaction of that transaction
	 */
	@Temporal(TemporalType.DATE)
	private Calendar dateOfTransaction;

	/**
	 * transactionStatus is use to store status of that transaction SUCCESS or
	 * FAILURE
	 */
	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionStatus;

	/**
	 * description is use to store any extra details you want to mention
	 */
	private String description;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Calendar getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(Calendar dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
