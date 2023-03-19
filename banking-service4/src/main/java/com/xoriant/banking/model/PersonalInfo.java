package com.xoriant.banking.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * This is PersonalInfo Model Class which is used as a data traveller between
 * different layers
 * 
 * @author Jangir_a
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonalInfo {

	/**
	 * personId field is use to uniquely indentify person
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int personId;
	/**
	 * personName field is use to store name of person
	 */
	protected String personName;
	/**
	 * telephoneNumber field is use to store telephone number of person
	 */
	protected String telephoneNumber;
	/**
	 * dateOfBirth field is use to store date of birth of person
	 */
	@Temporal(TemporalType.DATE)
	protected Calendar dob;
	/**
	 * email field is use to store email of a person
	 */
	protected String email;
	/**
	 * gender field is use to store gender
	 */
	@Enumerated(EnumType.STRING)
	protected Gender gender;
	/**
	 * user field is use to store user details like username, password and role of
	 * user
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	protected User user;
	/**
	 * branch field is use to store branch details
	 */
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "branchId")
	protected Branch branch;
	/**
	 * address field is use to store address details
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	protected Address address;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
