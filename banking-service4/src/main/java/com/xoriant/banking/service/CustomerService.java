package com.xoriant.banking.service;

import java.util.List;
import java.util.Map;

import com.xoriant.banking.exception.AccountIsInActiveException;
import com.xoriant.banking.exception.NotFoundException;
import com.xoriant.banking.exception.NotSufficientBalanceException;
import com.xoriant.banking.model.Account;
import com.xoriant.banking.model.Branch;
import com.xoriant.banking.model.Customer;
import com.xoriant.banking.model.Transactions;
import com.xoriant.banking.model.User;

/**
 * This is CustomerService interface
 * @author Jangir_a
 *
 */
public interface CustomerService {
	/**
	 * this method is use to find balance
	 * @param accountNumber
	 * @return
	 */
	public double balanceEnquiry(int accountNumber); 
	
	/**
	 * this method is use to get transactions of account of that accountNumber
	 * @param accountNumber
	 * @return
	 */
	public List<Transactions> miniStatement(long accountNumber); 
	
	
	/**
	 * this method is use to find account by id
	 * @param l
	 * @return
	 */
	public Account findAccountById(long l);
	/**
	 * this method is use to find customer by id
	 * @param customerId
	 * @return
	 */
	public Customer findCustomerByPersonId(Integer customerId); 
	


	/**
	 * this method is use to find branch by id
	 * @param id
	 * @return
	 */
	Branch getBranchByID(int id);
	/**
	 * this method is use to find customer account by id
	 * @param personId
	 * @return
	 */
	public Customer getCustomerByPersonId(int personId);

	/** 
	 * this method is use to find role account by id
	 * @param personId
	 * @return
	 */
	public String getRolebyId(Integer personId);

	/**
	 * this method is use to authenticate username and password
	 * @param userName
	 * @param password
	 * @return
	 * @throws NotFoundException
	 */
	public User authUser(String userName, String password) throws NotFoundException;

	/**
	 * this method is use to get details for manager
	 * @param user
	 * @return
	 */
	public Map<Object, Object> getDetailsforManager(User user);

	/**
	 * getDetails method takes user as an input and return map of personal details
	 * @param user
	 * @return
	 */
	public Map<Object, Object> getDetails(User user);

	/**
	 * findPersonIdByUserId is use to find person id by user id
	 * @param userId
	 * @return
	 */
	public int findPersonIdByUserId(int userId);
	

	
}