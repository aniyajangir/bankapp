package com.xoriant.banking.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




/**
 * This is User Model Class which is used as a data traveller between different layers
 * @author Jangir_a
 *
 */
@Entity
public class User {
	/**
	 * userId field is use to uniquely indentify any user
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	/**
	 * userName field is use to store userName of that user
	 */
	private String userName;
	/**
	 * password field is use to store password 
	 */
	private String password;
	/**
	 * role field is use to store role 
	 * manager or user
	 */
	private String role;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
