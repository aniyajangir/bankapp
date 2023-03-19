package com.xoriant.banking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xoriant.banking.model.Account;



public interface AccountDao extends JpaRepository<Account, Long>{

	@Modifying
	@Query("update Account a set a.accountBalance = :newamount where a.accountNumber = :accountnumber")
	void updateAccountBalance(@Param("accountnumber") long accountNumber,@Param("newamount") double amount);


	@Modifying
	@Query("update Account a set a.accountStatus = 'INACTIVE' where a.accountNumber = :accountnumber")
	void updateAccountStatus(@Param("accountnumber") long accountNumber);

	

	@Query("from Account a where a.accountNumber=?1")
	Account findAccountById(long accountNumber);




	
}
