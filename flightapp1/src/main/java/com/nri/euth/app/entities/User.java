package com.nri.euth.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long eid;
	
	private String emailId;

	private String firstName;

	private String lastName;

	private String qualification;

	private String designation;

	private String mobile;

	private String address;

	private String password;
	
	
	

	public User() {
		
	}
	
	

	public User(long eid, String emailId, String firstName, String lastName, String qualification, String designation,
			String mobile, String address, String password) {
		
		this.eid = eid;
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.qualification = qualification;
		this.designation = designation;
		this.mobile = mobile;
		this.address = address;
		this.password = password;
	}



	public long getEid() {
		return eid;
	}



	public void setEid(long eid) {
		this.eid = eid;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getQualification() {
		return qualification;
	}



	public void setQualification(String qualification) {
		this.qualification = qualification;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
		

}
