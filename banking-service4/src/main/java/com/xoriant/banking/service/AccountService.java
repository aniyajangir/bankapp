package com.xoriant.banking.service;

import com.xoriant.banking.command.AccountDTO;
import com.xoriant.banking.model.User;

/**
 * This is AccountService interface
 * @author Jangir_a
 *
 */

public interface AccountService {
	/**
	 * use to authenticate account
	 * @param accountNumber
	 * @return
	 */
	boolean authAccount(long accountNumber);
	
	
	/**
	 * use to create account
	 * create account
	 * @param accountDTO
	 * @return
	 */
	String createAccount(AccountDTO accountDTO);
	
	/**
	 * use to update account
	 * update
	 * @param aac
	 * @return 
	 */
	String update(AccountDTO aac);
	
	/**
	 * use to delete account
	 * @param accountNumber
	 */
	String deleteAccount(long accountNumber);


	String balanceEnquiry(long accountNumber,User user);
	

	
}
