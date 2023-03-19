package com.xoriant.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xoriant.banking.model.Account;
import com.xoriant.banking.model.PersonalInfo;
import com.xoriant.banking.model.User;



public interface PersonalInfoDao extends JpaRepository<PersonalInfo, Integer> {

	

	@Query("select p.personId from PersonalInfo p where p.user.userId =:userId")
	int findPersonByUser(@Param("userId") int userId);

	@Query("from PersonalInfo p where p.personId=?1")
	Account findPersonById(int personId);
		
}
