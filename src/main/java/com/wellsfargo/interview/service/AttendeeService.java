package com.wellsfargo.interview.service;

import com.wellsfargo.interview.entity.AttendeeEntity;
import com.wellsfargo.interview.exception.InterviewException;

public interface AttendeeService {

	AttendeeEntity add(AttendeeEntity attendee) throws InterviewException;
}
