package com.wellsfargo.interview.service;

import java.util.List;

import com.wellsfargo.interview.exception.InterviewException;
import com.wellsfargo.interview.model.UserModel;

public interface UserService {

	UserModel add(UserModel user) throws InterviewException;
	UserModel save(UserModel user) throws InterviewException;
	
	boolean deleteUser(int userId) throws InterviewException;
	
	UserModel getUser(int userId);
	List<UserModel> getAllUsers();
}
