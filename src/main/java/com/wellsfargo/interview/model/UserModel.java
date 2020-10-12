package com.wellsfargo.interview.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {

	@NotNull(message = "UserId is mandatory")
	private Integer userId;
	
	@NotNull(message = "First name is mandatory")
	@NotBlank(message = "First name is mandatory")
	@Size(min=5,max=30,message = "First name should be between 5 to 30 characters")
	private String firstName;
	
	@NotNull(message = "Last name is mandatory")
	@NotBlank(message = "Last name is mandatory")
	@Size(min=3,max=25,message = "Last name should be between 3 to 25 characters")
	private String lastName;
	
	@NotNull(message = "Email is mandatory")
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Email should be valid")
	private String email;
	
	@NotNull(message = "Mobile number is mandatory")
	@Size(min=10,max=10,message = "Mobile number should be exactly 10 characters")
	private String mobile;
	
	public UserModel()
	{
		
	}

	public UserModel(Integer userId, String firstName, String lastName, String email, String mobile) {
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", mobile=" + mobile + "]";
	}
	
}
