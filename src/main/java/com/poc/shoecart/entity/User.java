package com.poc.shoecart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "user_id")
	public long userId;

	@Column(name = "name")
	public String name;

	@Column(name = "mobile_number")
	public String mobileNumber;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long userId, String name, String mobileNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.mobileNumber = mobileNumber;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", mobileNumber=" + mobileNumber + "]";
	}

}
