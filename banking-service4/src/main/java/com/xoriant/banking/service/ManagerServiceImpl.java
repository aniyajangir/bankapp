package com.xoriant.banking.service;

import static com.xoriant.banking.constants.ApplicationConstant.INVALID_ACCOUNT_NUMBER;
import static com.xoriant.banking.constants.ApplicationConstant.SOMETHING_IS_WRONG_TRY_AGAIN;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xoriant.banking.command.CustomerDTO;
import com.xoriant.banking.command.TransactionsDTO;
import com.xoriant.banking.exception.AccountIsInActiveException;
import com.xoriant.banking.exception.NotFoundException;
import com.xoriant.banking.exception.NotSufficientBalanceException;
import com.xoriant.banking.exception.OldPasswordIsNotCorrectException;
import com.xoriant.banking.model.Account;
import com.xoriant.banking.model.Address;
import com.xoriant.banking.model.Branch;
import com.xoriant.banking.model.Customer;
import com.xoriant.banking.model.Gender;
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
 * ManagerServiceImpl is an implementation of ManagerService interface
 * 
 * @author Jangir_a
 *
 */
@Transactional
@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	CustomerDao customerDao;
	@Autowired
	ApplicationContext context;
	@Autowired
	AccountDao accountDao;
	@Autowired
	TransactionDao transactionDao;
	@Autowired
	UserDao userDao;
	@Autowired
	BranchDao branchDao;
	@Autowired
	AddressDao addressDao;
	@Autowired
	ManagerDao managerDao;
	@Autowired
	PersonalInfoDao personalInfoDao;
	@Autowired
	AccountService accountService;


	@Override
	public String deposit(TransactionsDTO transactionsDTO) {
		boolean res = accountService.authAccount(transactionsDTO.getToAccountNumber());

		try {
			if (res) {
				Account account = accountDao.findAccountById(transactionsDTO.getToAccountNumber());
				if (account.getAccountStatus() == Status.INACTIVE) {
					throw new AccountIsInActiveException();
				} else {
					accountDao.updateAccountBalance(account.getAccountNumber(),
							account.getAccountBalance() + transactionsDTO.getAmount());
				}
				return "deposit is successful";
			} else
				return INVALID_ACCOUNT_NUMBER;
		} catch (AccountIsInActiveException e) {
			return e.toString();
		} catch (Exception e) {
			return INVALID_ACCOUNT_NUMBER;
		}

	}

	@Override
	public String withdrawal(TransactionsDTO transactionsDTO) {

		boolean res = accountService.authAccount(transactionsDTO.getFromAccountNumber());
		try {
			if (res) {
				Account account = accountDao.findAccountById(transactionsDTO.getFromAccountNumber());
				double balance = account.getAccountBalance();

				if (account.getAccountStatus() == Status.INACTIVE) {
					throw new AccountIsInActiveException();
				} else if (balance < transactionsDTO.getAmount()) {
					throw new NotSufficientBalanceException();
				}

				else {
					accountDao.updateAccountBalance(account.getAccountNumber(),
							account.getAccountBalance() - transactionsDTO.getAmount());
				}

				return "Withdraw is successful";
			} else
				return INVALID_ACCOUNT_NUMBER;
		} catch (AccountIsInActiveException e) {
			return e.toString();
		} catch (Exception e) {
			return INVALID_ACCOUNT_NUMBER;
		}

	}

	@Override
	public void changePassword(String oldPassword, String newPassword, String confirmPassword, int userId)
			throws OldPasswordIsNotCorrectException {
		User user = userDao.findById(userId).get();
		if (user.getPassword().equals(oldPassword)) {
			if (confirmPassword.equals(newPassword))
				user.setPassword(newPassword);
			System.out.println("hey 5");
			userDao.updateUser(user.getUserId(), newPassword);
		} else {
			throw new OldPasswordIsNotCorrectException();
		}
	}

	@Override
	public double balanceEnquiry(long accountNumber) {
		Account account = accountDao.findAccountById(accountNumber);
		return account.getAccountBalance();

	}

	@Override
	public List<TransactionsDTO> miniStatement(long accountNumber, User user) throws NotFoundException {
		
		if ((user.getRole().equals("customer")
				&& accountDao.findById(accountNumber).get().getCustomer().getUser().getUserId() == user.getUserId())
				|| user.getRole().equals("manager")) {
			List<TransactionsDTO> transactionsDTOs = new ArrayList<TransactionsDTO>();
			TransactionsDTO transactionsDTO = new TransactionsDTO();
			List<Transactions> transactions = transactionDao.statement(accountNumber);
			System.out.println("hhf");
			for (int i = 0 ; i < transactions.size() ; i++ ) {
				transactionsDTO.setAmount(transactions.get(i).getAmount());
				transactionsDTO.setDescription(transactions.get(i).getDescription());
				transactionsDTO.setFromAccountNumber(transactions.get(i).getFromAccount().getAccountNumber());
				transactionsDTO.setToAccountNumber(transactions.get(i).getToAccount().getAccountNumber());
				transactionsDTO.setDate(transactions.get(i).getDateOfTransaction().getTime().toString().substring(0, 11)+transactions.get(i).getDateOfTransaction().getTime().toString().substring(24, 28));
				transactionsDTO.setStatus(transactions.get(i).getTransactionStatus());
				
				transactionsDTOs.add(transactionsDTO);
				
			}
			
			return transactionsDTOs;
		} else {
			throw new NotFoundException();
		}

	}

	@Override
	public String addCustomer(CustomerDTO acd, int userId) {
		try {
			int personId = findPersonIdByUserId(userId);
			Customer customer = new Customer();
			customer.setPersonName(acd.getPersonName());
			customer.setGender(acd.getGender());
			customer.setCustomerStatus(acd.getCustomerStatus());

			DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
			Date date;
			try {
				date = df.parse(acd.getDate());
				Calendar cal = new GregorianCalendar();
				cal.setTime(date);
				customer.setDob(cal);
				System.out.println(cal.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Address address = new Address();
			address.setFlatNo(acd.getFlatNo());
			address.setCity(acd.getCity());
			address.setState(acd.getState());
			address.setPincode(acd.getPincode());

			User user = new User();
			user.setUserName(acd.getUsername());
			user.setPassword(acd.getPassword());
			user.setRole("customer");
			Manager manager = managerFindById(personId);

			System.out.println(manager.getPersonId());
			customer.setCustomerStatus(Status.ACTIVE);
			customer.setTelephoneNumber(acd.getTelephoneNumber());
			customer.setEmail(acd.getEmail());
			customer.setManager(manager);
			customer.setAddress(address);

			customer.setBranch(getBranchByID(manager.getBranch().getBranchId()));

			customer.setUser(user);

			addressDao.save(address);
			userDao.save(user);
			customer = customerDao.save(customer);

			return "Customer is successfully created with id " + customer.getPersonId();
		} catch (Exception e) {
			return "Try again";
		}

	}

	@Override
	public String deleteCustomer(int personId) {
		try {
			if (!authCustomerId(personId)) {
				throw new NotFoundException();
			} else {

				Customer customer = customerFindById(personId);
				if (customer.getCustomerStatus() == Status.INACTIVE) {
					System.out.println("dsf");
					return "Customer does not exist";
				}
				customer.setCustomerStatus(Status.INACTIVE);

				if (customerDao.findCustomerById(personId).getAccounts().size() != 0) {
					List<Account> listOfAccounts = customerDao.findById(personId).get().getAccounts();
					for (Account account : listOfAccounts) {
						account.setAccountStatus(Status.INACTIVE);
						accountDao.save(account);
					}
				}
				customerDao.save(customer);
				return "Customer Deleted Successfully";
			}
		} catch (NotFoundException e) {
			return "Customer does not exist";
		} catch (Exception e) {
			return SOMETHING_IS_WRONG_TRY_AGAIN;
		}

	}

	
	@Override
	public Customer customerFindById(Integer personId) {
		return customerDao.findCustomerById(personId);
	}

	@Override
	public PersonalInfo personalInfoFindById(Integer userId) {
		return personalInfoDao.findById(userId).get();
	}

	@Override
	public Branch branchFindById(Integer branchId) {
		return branchDao.findById(branchId).get();
	}

	@Override
	public Address adderssFindById(Integer addressId) {
		return addressDao.findById(addressId).get();
	}

	@Override
	public Manager managerFindById(Integer personId) {
		return managerDao.findById(personId).get();
	}

	@Override
	public PersonalInfo login(String loginName, String password) throws NotFoundException {
		User user = userDao.authenticateUser(loginName, password);
		Manager manager = managerDao.findById(user.getUserId()).get();

		if (manager != null)
			return manager;
		return null;
	}

	@Override
	public Branch getBranchByID(int id) {
		return branchDao.findById(id).get();
	}

	@Override
	public boolean authUserName(String userName) throws NotFoundException {
		User user = userDao.findByUserName(userName);
		if (user == null)
			return false;
		else
			return true;
	}

	@Override
	public int findPersonIdByUserId(int userId) {
		int personId = personalInfoDao.findPersonByUser(userId);
		return personId;

	}

	@Override
	public boolean authUserId(int userId) {

		return userDao.existsById(userId);
	}

	@Override
	public boolean authCustomerId(int customerId) {

		return customerDao.existsById(customerId);
	}

	@Override
	public String fundTransfer(TransactionsDTO transactionsDTO, User user) {
		try {

			boolean toAccountCheck = accountService.authAccount(transactionsDTO.getToAccountNumber());
			boolean fromAccountCheck = accountService.authAccount(transactionsDTO.getFromAccountNumber());
			if (toAccountCheck && fromAccountCheck
					&& (transactionsDTO.getToAccountNumber() != transactionsDTO.getFromAccountNumber())) {
				if ((user.getRole().equals("customer") && accountDao.findById(transactionsDTO.getFromAccountNumber())
						.get().getCustomer().getUser().getUserId() == user.getUserId())
						|| user.getRole().equals("manager")) {

					Transactions trx1 = new Transactions();
					Account toAccount = accountDao.findById(transactionsDTO.getToAccountNumber()).get();
					Account fromAccount = accountDao.findById(transactionsDTO.getFromAccountNumber()).get();
					if (toAccount.getAccountStatus() == Status.INACTIVE
							|| fromAccount.getAccountStatus() == Status.INACTIVE) {
						throw new AccountIsInActiveException();
					} else {
						trx1.setAmount(transactionsDTO.getAmount());
						Date d = new Date();
						trx1.setDateOfTransaction(new GregorianCalendar());
						trx1.setFromAccount(fromAccount);
						trx1.setToAccount(toAccount);
						trx1.setDescription(transactionsDTO.getDescription());
						double balance1 = fromAccount.getAccountBalance();
						double balance2 = toAccount.getAccountBalance();
						if (balance1 < transactionsDTO.getAmount()) {
							trx1.setTransactionStatus(TransactionStatus.FAILED);
							transactionDao.save(trx1);
							throw new NotSufficientBalanceException();
						} else {

							trx1.setTransactionStatus(TransactionStatus.SUCCESS);
							accountDao.updateAccountBalance(transactionsDTO.getFromAccountNumber(),
									(balance1 - transactionsDTO.getAmount()));
							accountDao.updateAccountBalance(transactionsDTO.getToAccountNumber(),
									(balance2 + transactionsDTO.getAmount()));
						}
						transactionDao.save(trx1);

					}
					return "Fund is Transfered successfully";
				} else {
					return INVALID_ACCOUNT_NUMBER;

				}
			}

			else {
				return INVALID_ACCOUNT_NUMBER + " Or both accounts are same";
			}

		} catch (AccountIsInActiveException e) {
			return e.toString();
		} catch (NotSufficientBalanceException e) {
			return e.toString();
		} catch (Exception e) {
			return INVALID_ACCOUNT_NUMBER;
		}
	}

	@Override
	public String updateCustomer(CustomerDTO customerDTO) {
		try {
			if (!authCustomerId(customerDTO.getPersonId())) {
				throw new NotFoundException();
			} else {
				Customer customer = customerFindById(customerDTO.getPersonId());
				customer.setPersonName(customerDTO.getPersonName());
				customer.setEmail(customerDTO.getEmail());
				customer.setTelephoneNumber(customerDTO.getTelephoneNumber());
				customer.setGender(customerDTO.getGender());
				customerDao.save(customer);
				return "customer is updated";
			}
		} catch (NotFoundException e) {
			return e.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
