package com.wellsfargo.interview.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.interview.exception.InterviewException;
import com.wellsfargo.interview.model.UserModel;
import com.wellsfargo.interview.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserModel>> getAllUsers(){
		return new ResponseEntity<List<UserModel>>(userService.getAllUsers(),HttpStatus.OK);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<UserModel> getUser(@PathVariable("id")int userId){
		ResponseEntity<UserModel> resp=null;
		
		UserModel user = userService.getUser(userId);
		
		if(user!=null) {
			resp =new ResponseEntity<>(user,HttpStatus.OK);
		}else {
			resp =new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<UserModel> createLoan(@RequestBody @Valid UserModel loan,BindingResult result) throws InterviewException{
		if(result.hasErrors()) {
			throw new InterviewException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<>(userService.add(loan),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<UserModel> modifyLoan(@RequestBody @Valid UserModel loan,BindingResult result) throws InterviewException{
		if(result.hasErrors()) {
			throw new InterviewException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<>(userService.save(loan),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id")int userId) throws InterviewException{
		userService.deleteUser(userId);		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
