package com.wellsfargo.interview.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.interview.entity.AttendeeEntity;
import com.wellsfargo.interview.entity.UserEntity;
import com.wellsfargo.interview.exception.InterviewException;
import com.wellsfargo.interview.service.AttendeeService;

@RestController
@RequestMapping("/Attendees")
public class AttendeeRestController {

	@Autowired
	private AttendeeService attendeeService;
	
	@GetMapping("/{id}")
	public ResponseEntity<List<UserEntity>> getAllAttendees(@PathVariable("id") int interview)
	{
		return new ResponseEntity<List<UserEntity>>(attendeeService.getAllAttendees(interview),HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<AttendeeEntity> createAttendee(@RequestBody @Valid AttendeeEntity attendee,BindingResult result) throws InterviewException{
		if(result.hasErrors()) {
			throw new InterviewException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<AttendeeEntity>(attendeeService.add(attendee),HttpStatus.OK);
	}
}
