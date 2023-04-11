package com.sapient.vo;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
	
	Long user_id;
	
	String name;
	Date dateOfBirth;
	String mobileNumber;
	String emailId;
	String sex;
	
	
	
	public User(String name, Date dateOfBirth, String mobileNumber, String emailId, String sex) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.sex = sex;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	

}
