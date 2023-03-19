package com.xoriant.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.xoriant.banking.model.Customer;


public interface CustomerDao extends JpaRepository<Customer, Integer>{


	@Modifying
	@Query("update Customer c set c.customerStatus = 'INACTIVE' where c.personId = :personId")
	void updateCustomer(@Param("personId") int personId);


	@Query("from Customer c where c.personId = :personId")
	Customer findCustomerById(@Param("personId") Integer personId);

	
	
	
}
