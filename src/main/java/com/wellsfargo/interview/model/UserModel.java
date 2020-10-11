package com.wellsfargo.interview.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserModel {

	@NotNull(message = "UserId is mandatory")
	private Integer userId;
	
	@NotNull(message = "First name is mandatory")
	@NotBlank(message = "First name is mandatory")
	@Min(value=5,message = "First name should be minimum 5 characters")
	@Max(value=30,message = "First name cannot be more than 30 characters")
	private String firstName;
	
	@NotNull(message = "Last name is mandatory")
	@NotBlank(message = "Last name is mandatory")
	@Min(value=3,message = "Last name should be minimum 3 characters")
	@Max(value=25,message = "Last name cannot be more than 25 characters")
	private String lastName;
	
	@NotNull(message = "Email is mandatory")
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	private String email;
	
	@NotNull(message = "Mobile number is mandatory")
	@Min(value=10,message = "Mobile number should be minimum 10 characters")
	@Max(value=10,message = "Mobile number cannot be more than 10 characters")
	private Integer mobile;
	
	public UserModel()
	{
		
	}

	public UserModel(Integer userId, String firstName, String lastName, String email, Integer mobile) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", mobile=" + mobile + "]";
	}
	
}
