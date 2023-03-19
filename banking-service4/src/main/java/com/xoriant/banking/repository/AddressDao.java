package com.xoriant.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xoriant.banking.model.Address;


public interface AddressDao extends JpaRepository<Address, Integer>{

}
