package com.xoriant.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xoriant.banking.model.Transactions;

public interface TransactionDao extends JpaRepository<Transactions, Integer > {	

	@Query("FROM Transactions t"
	          + " where t.fromAccount.accountNumber = :accountNumber")
	List<Transactions> statement(@Param("accountNumber") long accountNumber);
	


	
}