package com.xoriant.banking.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.banking.model.Manager;

public interface ManagerDao extends JpaRepository<Manager, Integer>{
	
}
