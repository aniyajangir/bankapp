package com.xoriant.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/** 
 * This is Account Model Class which is used as a data traveller between different layers
 * @author Jangir_a
 *
 */
@Entity
public class Branch {

	/**
	 * branchId field is use to uniquely indentify account
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int branchId;
	/**
	 * branchName field is use to store name of Branch
	 */
	private String branchName;
	/**
	 * IFSC field is use to store IFSC code
	 */
	private String IFSC;
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	
	
	

}
