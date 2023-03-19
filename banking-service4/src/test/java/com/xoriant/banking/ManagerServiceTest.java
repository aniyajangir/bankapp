package com.xoriant.banking;

import static org.mockito.ArgumentMatchers.any;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.xoriant.banking.command.TransactionsDTO;
import com.xoriant.banking.model.Account;
import com.xoriant.banking.model.Status;
import com.xoriant.banking.repository.AccountDao;
import com.xoriant.banking.service.AccountService;
import com.xoriant.banking.service.ManagerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {


	ObjectMapper objectMapper=new ObjectMapper();
	ObjectWriter objectWriter=objectMapper.writer();
	
	@Mock
	private AccountDao accountDao;
	
	@InjectMocks
	private ManagerServiceImpl managerService;
	
	@Mock
	private AccountService accountService;
	
	@org.junit.Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void balanceEnquiry_TakeLongAccountNumber_ReturnaDoubleAccountBalance() throws Exception{
		
		Account account=new Account();
		account.setAccountNumber(2);
		account.setAccountBalance(5000.0);
		account.setAccountStatus(Status.ACTIVE);
		
		long accountNumber = 2;
		
		Mockito.when(accountDao.findAccountById(any(Long.class))).thenReturn(account);
		
		double result=managerService.balanceEnquiry(accountNumber);
		Assert.assertEquals(5000.0, result, 0);
	}
	
	@Test
	public void deposit_TakeTransactionsDTOtransactionsDTO_ReturnaStringResult() throws Exception{
		
		Account account=new Account();
		account.setAccountNumber(7);
		account.setAccountBalance(5000.0);
		account.setAccountStatus(Status.ACTIVE);
		
		TransactionsDTO transactionsDTO = new TransactionsDTO();
		transactionsDTO.setAmount(200);
		transactionsDTO.setToAccountNumber(7);
		transactionsDTO.setDescription("depositing");
		
		String msg = "deposit is successful";
		
		Mockito.when(accountDao.findAccountById(any(Long.class))).thenReturn(account);
		Mockito.when(accountService.authAccount(any(Long.class))).thenReturn(true);

		String result=managerService.deposit(transactionsDTO);
		Assert.assertEquals(msg, result);
		
	}
	
	@Test
	public void withdraw_TakeTransactionsDTOtransactionsDTO_ReturnaStringResult() throws Exception{
		
		Account account=new Account();
		account.setAccountNumber(7);
		account.setAccountBalance(5000.0);
		account.setAccountStatus(Status.ACTIVE);
		
		TransactionsDTO transactionsDTO = new TransactionsDTO();
		transactionsDTO.setAmount(200);
		transactionsDTO.setFromAccountNumber(7);
		transactionsDTO.setDescription("withdrawing money");
		
		String msg = "withdraw is successful";
		
		Mockito.when(accountDao.findAccountById(any(Long.class))).thenReturn(account);
		Mockito.when(accountService.authAccount(any(Long.class))).thenReturn(true);

		String result=managerService.withdrawal(transactionsDTO);
		Assert.assertEquals(msg, result);
		
	}
}