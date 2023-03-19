package com.xoriant.banking.service;

import java.util.List;

import com.xoriant.banking.command.CustomerDTO;
import com.xoriant.banking.command.TransactionsDTO;
import com.xoriant.banking.exception.AccountIsInActiveException;
import com.xoriant.banking.exception.NotFoundException;
import com.xoriant.banking.exception.OldPasswordIsNotCorrectException;
import com.xoriant.banking.model.Account;
import com.xoriant.banking.model.Address;
import com.xoriant.banking.model.Branch;
import com.xoriant.banking.model.Customer;
import com.xoriant.banking.model.Manager;
import com.xoriant.banking.model.PersonalInfo;
import com.xoriant.banking.model.User;




/**
 * This is ManagerService
 * @author Jangir_a
 *
 */
public interface ManagerService {



	/**
	 * this method use change password
	 * 
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmPassword
	 * @param userId
	 * @throws OldPasswordIsNotCorrectException 
	 */
	public void changePassword(String oldPassword, String newPassword, String confirmPassword, int userId) throws OldPasswordIsNotCorrectException;

	/**
	 * this method is use to find balance
	 * 
	 * @param accountNumber
	 * @return
	 */
	public double balanceEnquiry(long accountNumber);

	/**
	 * this method is use to get transactions of account of that accountNumber
	 * @param accountNumber
	 * @param user 
	 * @return
	 * @throws NotFoundException 
	 */
	public List<TransactionsDTO> miniStatement(long accountNumber, User user) throws NotFoundException;




	/**
	 * this method is use to delete Customer
	 * @param customerId
	 * @return 
	 */
	public String deleteCustomer(int customerId);


	/**
	 * this method is use to transfer funds
	 * @param transactionsDTO
	 * @param user
	 */
	public String fundTransfer(TransactionsDTO transactionsDTO, User user);
	

	/**
	 * this method is use to add Customer
	 * @param acd
	 * @param personId
	 * @return
	 */
	String addCustomer(CustomerDTO acd , int personId);
	
	/**
	 * this method is use to edit Customer
	 * @param customerDTO
	 * @return
	 */
	String updateCustomer(CustomerDTO customerDTO);
	
	/**
	 * this method is use to login
	 * @param loginName
	 * @param password
	 * @return
	 * @throws NotFoundException 
	 */
	public PersonalInfo login(String loginName,String password) throws NotFoundException;

	/**
	 * this method is use to withdraw
	 * @param transactionsDTO
	 * @return 
	 */
	String withdrawal(TransactionsDTO transactionsDTO);

	/**
	 * this method is use to find manager by id
	 * @param personId
	 * @return
	 */
	public Manager managerFindById(Integer personId);


	/**
	 * this method is use to find address by id
	 * @param addressId
	 * @return
	 */
	public Address adderssFindById(Integer addressId);


	/**
	 * this method is use to find branch by id
	 * @param branchId
	 * @return
	 */
	public Branch branchFindById(Integer branchId);


	/**
	 * this method is use to find person by id
	 * @param userId
	 * @return
	 */
	public PersonalInfo personalInfoFindById(Integer userId);


	/**
	 * this method is use to find customer by id
	 * @param personId
	 * @return
	 */
	public Customer customerFindById(Integer personId);




	
	/**
	 * this method is use to find branch by id
	 * @param id
	 * @return
	 */
	public Branch getBranchByID(int id);


	/**
	 * This method is use to authenticate user
	 * @param userId
	 * @return
	 * @throws NotFoundException 
	 */
	boolean authUserName(String userName) throws NotFoundException;


	

	/**
	 * This method is use to find person id using user id
	 * @param userId
	 * @return
	 * @throws NotFoundException 
	 */
	int findPersonIdByUserId(int userId) ;



	public boolean authUserId(int attribute);



	String deposit(TransactionsDTO transactionsDTO);



	boolean authCustomerId(int customerId);



	




}