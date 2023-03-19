package com.xoriant.banking.exception;

public class NotSufficientBalanceException extends Exception{
@Override
public String toString() {
	return "Your Balance is not sufficient. ";
	
}
}
