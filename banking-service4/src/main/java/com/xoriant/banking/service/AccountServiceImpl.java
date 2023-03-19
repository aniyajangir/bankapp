package com.xoriant.banking.service;

import static com.xoriant.banking.constants.ApplicationConstant.ACCOUNT_IS_SUCCESSFULLY_CREATED;
import static com.xoriant.banking.constants.ApplicationConstant.I1;
import static com.xoriant.banking.constants.ApplicationConstant.INVALID_ACCOUNT_NUMBER;
import static com.xoriant.banking.constants.ApplicationConstant.SOMETHING_IS_WRONG_TRY_AGAIN;
import static com.xoriant.banking.constants.ApplicationConstant.THIS_CUSTOMER_ID_IS_NOT_VALID;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.banking.command.AccountDTO;
import com.xoriant.banking.model.Account;
import com.xoriant.banking.model.AccountType;
import com.xoriant.banking.model.Customer;
import com.xoriant.banking.model.Status;
import com.xoriant.banking.model.User;
import com.xoriant.banking.repository.AccountDao;
import com.xoriant.banking.repository.CustomerDao;
import com.xoriant.banking.repository.PersonalInfoDao;

import lombok.Data;

/**
 * AccountServiceImpl is an implementation of AccountService
 * @author Jangir_a
 *
 */
@Transactional
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private PersonalInfoDao personalInfoDao;

	
	
	@Override
	public boolean authAccount(long accountNumber) {
		
		Account account=accountDao.findAccountById(accountNumber);
		if(account==null)
		return false;
		else
			return true;
	}
	


	
	@Override
	public String update(AccountDTO accountDTO) {
		boolean res = authAccount(accountDTO.getAccountNo());
		try {
			if (res) {
				if (accountDao.findAccountById(accountDTO.getAccountNo())!=null) {
					Account account = accountDao.findAccountById(accountDTO.getAccountNo());
					account.setAccountType(accountDTO.getAccountType());
					account.setAccountStatus(accountDTO.getStatus());
					accountDao.save(account);
					}
				return "Account updated";
			} else {
				return "Account Not Found";
			}
		} catch (Exception e) {
			return SOMETHING_IS_WRONG_TRY_AGAIN;
		}
		
		
		
	}

	@Override
	public String createAccount(AccountDTO accountDTO) {
		try {
			
		if (personalInfoDao.findById(accountDTO.getPersonId())!=null) {
				

		Customer customer = customerDao.findById(accountDTO.getPersonId()).get();
		Account account1 = new Account();

		account1.setAccountBalance(accountDTO.getBalance());
		account1.setAccountStatus(accountDTO.getStatus());
		account1.setAccountType(accountDTO.getAccountType());
		account1.setDate(new GregorianCalendar());
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + I1);
		account1.setDateOfClosure(calendar);
		account1.setDescription("desc");
		account1.setMinimumBalance(accountDTO.getMinBalance());
		account1.setCustomer(customer);

		account1 = accountDao.save(account1);
		
		return ACCOUNT_IS_SUCCESSFULLY_CREATED+" with account number "+account1.getAccountNumber();
	} else {
		System.out.println("sddsf");
		return THIS_CUSTOMER_ID_IS_NOT_VALID;
	}
} catch (Exception e) {
	return THIS_CUSTOMER_ID_IS_NOT_VALID;
}

	}





	@Override
	public String balanceEnquiry(long accountNumber,User user) {

		try {
			boolean check = authAccount(accountNumber);
			if (check) {
				if((user.getRole().equals("customer") && accountDao.findById(accountNumber).get().getCustomer().getUser().getUserId()==user.getUserId())||user.getRole().equals("manager")) {
				return accountDao.findAccountById(accountNumber).getAccountBalance()+"" ;
				}
				return "Account not found";
				
			} else
				
			return INVALID_ACCOUNT_NUMBER;
		} catch (Exception e) {
			return INVALID_ACCOUNT_NUMBER;
		}
	}





		@Override
		public String deleteAccount(long accountNumber) {
			
			try {
				boolean check = authAccount(accountNumber);
				if (check) {
					
					Account account = accountDao.findById(accountNumber).get();
					if(account.getAccountStatus()==Status.INACTIVE) {
						return INVALID_ACCOUNT_NUMBER;
					}
					account.setAccountStatus(Status.INACTIVE);
					accountDao.save(account);
					return "Account is deleted";
				} else {
					return INVALID_ACCOUNT_NUMBER;
				}
			} catch (Exception e) {
				return SOMETHING_IS_WRONG_TRY_AGAIN;
			}
			
			
		}

	





}