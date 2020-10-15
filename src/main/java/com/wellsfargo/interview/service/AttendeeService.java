package com.wellsfargo.interview.service;

import java.util.List;

import com.wellsfargo.interview.entity.AttendeeEntity;
import com.wellsfargo.interview.entity.UserEntity;
import com.wellsfargo.interview.exception.InterviewException;

public interface AttendeeService {

	AttendeeEntity add(AttendeeEntity attendee) throws InterviewException;
	List<UserEntity> getAllAttendees(int interview);
}
