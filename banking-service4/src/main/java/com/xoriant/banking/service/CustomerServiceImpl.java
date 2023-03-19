package com.xoriant.banking.service;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.banking.exception.AccountIsInActiveException;
import com.xoriant.banking.exception.NotFoundException;
import com.xoriant.banking.exception.NotSufficientBalanceException;
import com.xoriant.banking.model.Account;
import com.xoriant.banking.model.Address;
import com.xoriant.banking.model.Branch;
import com.xoriant.banking.model.Customer;
import com.xoriant.banking.model.Manager;
import com.xoriant.banking.model.PersonalInfo;
import com.xoriant.banking.model.Status;
import com.xoriant.banking.model.TransactionStatus;
import com.xoriant.banking.model.Transactions;
import com.xoriant.banking.model.User;
import com.xoriant.banking.repository.AccountDao;
import com.xoriant.banking.repository.AddressDao;
import com.xoriant.banking.repository.BranchDao;
import com.xoriant.banking.repository.CustomerDao;
import com.xoriant.banking.repository.ManagerDao;
import com.xoriant.banking.repository.PersonalInfoDao;
import com.xoriant.banking.repository.TransactionDao;
import com.xoriant.banking.repository.UserDao;

/**
 * CustomerServiceImpl is an implementation of CustomerService interface
 * 
 * @author Jangir_a
 *
 */
@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	AccountDao accountDao;
	@Autowired
	TransactionDao transactionDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	BranchDao branchDao;
	@Autowired
	AddressDao addressDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	PersonalInfoDao personalInfoDao;

	@Override
	public double balanceEnquiry(int accountNumber) {
		Account account = findAccountById(accountNumber);

		return account.getAccountBalance();
	}

	@Override
	public Account findAccountById(long accountNumber) {
		return accountDao.findById(accountNumber).get();
	}

	@Override
	public Customer findCustomerByPersonId(Integer personId) {
		return customerDao.findById(personId).get();
	}

	@Override
	public String getRolebyId(Integer personId) {
		return userDao.findById(personId).get().getRole();

	}

	@Override
	public Branch getBranchByID(int id) {
		return branchDao.findById(id).get();
	}

	@Override
	public Customer getCustomerByPersonId(int personId) {
		return customerDao.findById(personId).get();
	}

	@Override
	public User authUser(String userName, String password) {
		System.out.println(userName);
		User user = userDao.authenticateUser(userName, password);
		System.out.println(user);
		return user;
	}

	@Override
	public Map<Object, Object> getDetails(User user) {
		Map<Object, Object> userDetails = new HashMap<Object, Object>();

		int personId = findPersonIdByUserId(user.getUserId());
		Customer personalInfo = customerDao.findById(personId).get();
		userDetails.put("personId", personalInfo.getPersonId());
		userDetails.put("name", personalInfo.getPersonName());
		userDetails.put("gender", personalInfo.getGender());

		Branch branch = personalInfo.getBranch();
		userDetails.put("branch", branch.getBranchName());
		userDetails.put("IFSC", branch.getIFSC());

		Address address = personalInfo.getAddress();
		userDetails.put("city", address.getCity());
		userDetails.put("flatNo", address.getFlatNo());
		userDetails.put("pin", address.getPincode());
		userDetails.put("state", address.getState());
		return userDetails;
	}

	@Override
	public Map<Object, Object> getDetailsforManager(User user) {
		Map<Object, Object> userDetails = new HashMap<Object, Object>();
		Manager personalInfo = managerDao.findById(user.getUserId()).get();
		System.out.println(personalInfo);
		userDetails.put("personId", personalInfo.getPersonId());
		userDetails.put("name", personalInfo.getPersonName());
		userDetails.put("gender", personalInfo.getGender());

		Branch branch = personalInfo.getBranch();
		userDetails.put("branch", branch.getBranchName());
		userDetails.put("IFSC", branch.getIFSC());

		Address address = personalInfo.getAddress();
		userDetails.put("city", address.getCity());
		userDetails.put("flatNo", address.getFlatNo());
		userDetails.put("pin", address.getPincode());
		userDetails.put("state", address.getState());

		System.out.println(userDetails);
		return userDetails;
	}

	@Override
	public List<Transactions> miniStatement(long accountNumber) {
		return transactionDao.statement(accountNumber);
	}

	@Override
	public int findPersonIdByUserId(int userId) {
		// User user = userDao.findById(userId).get();
		int personId = personalInfoDao.findPersonByUser(userId);
		return personId;
	}

}