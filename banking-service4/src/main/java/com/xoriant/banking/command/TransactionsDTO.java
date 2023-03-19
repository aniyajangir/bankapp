package com.xoriant.banking.command;

import com.xoriant.banking.model.TransactionStatus;

/**
 * FundTransferCommand is command to use to transfer fund
 * 
 * @author Jangir_a
 *
 */

public class TransactionsDTO {
//	@Min(value=1, message="fill all the fields")  
	private long toAccountNumber;
	// @Min(value=1, message="fill all the fields")
	private long fromAccountNumber;
	// @DecimalMin("1.0")
	private double amount;
	// @NotBlank(message = "Fill all the fields")
	String description;
	private String date;
	private TransactionStatus status;

	public long getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public long getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

}
