package com.wellsfargo.interview.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.interview.entity.AttendeeEntity;
import com.wellsfargo.interview.exception.InterviewException;
import com.wellsfargo.interview.service.AttendeeService;

@RestController
@RequestMapping("/Attendees")
public class AttendeeController {

	@Autowired
	private AttendeeService attendeeService;
	
	@PostMapping
	public ResponseEntity<String> createAttendee(@RequestBody @Valid AttendeeEntity attendee,BindingResult result) throws InterviewException{
		if(result.hasErrors()) {
			throw new InterviewException(GlobalExceptionController.errMsgFrom(result));
		}
		attendeeService.add(attendee);
		return new ResponseEntity<String>("User has applied to given interview successfully",HttpStatus.OK);
	}
}
