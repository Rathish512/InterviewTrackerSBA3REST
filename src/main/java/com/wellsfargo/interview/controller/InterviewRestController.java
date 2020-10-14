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
import com.wellsfargo.interview.model.InterviewModel;
import com.wellsfargo.interview.service.InterviewService;

@RestController
@RequestMapping("/interview")
public class InterviewRestController {

	@Autowired
	private InterviewService interviewService;
	
	@GetMapping
	public ResponseEntity<List<InterviewModel>> getAllInterviews(){
		return new ResponseEntity<List<InterviewModel>>(interviewService.getAllInterviews(),HttpStatus.OK);
	}
	
	@GetMapping("/{InterviewName}")
	public ResponseEntity<List<InterviewModel>> getAllInterviewsByName(@PathVariable("InterviewName") String name)
	{

		return new ResponseEntity<List<InterviewModel>>(interviewService.getAllInterviewByName(name),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<InterviewModel> createInterview(@RequestBody @Valid InterviewModel interview,BindingResult result) throws InterviewException{
		if(result.hasErrors()) {
			throw new InterviewException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<>(interviewService.add(interview),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<InterviewModel> modifyInterview(@RequestBody @Valid InterviewModel interview,BindingResult result) throws InterviewException{
		if(result.hasErrors()) {
			throw new InterviewException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<>(interviewService.save(interview),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInterview(@PathVariable("id")int interviewId) throws InterviewException{
		interviewService.deleteInterview(interviewId);		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
