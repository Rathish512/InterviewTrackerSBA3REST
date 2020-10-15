package com.wellsfargo.interview.service;

import java.util.List;

import com.wellsfargo.interview.exception.InterviewException;
import com.wellsfargo.interview.model.InterviewModel;

public interface InterviewService {

	InterviewModel add(InterviewModel interview) throws InterviewException;
	InterviewModel save(InterviewModel interview) throws InterviewException;
	
	boolean deleteInterview(int interviewId) throws InterviewException;
	
	InterviewModel getInterview(int interviewId);
	List<InterviewModel> getAllInterviews();
	
	List<InterviewModel> getAllInterviewByName(String name);
	
	Integer getTotalNoofinterviews();
	
}
