package com.wellsfargo.interview.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.interview.dao.AttendeeDao;
import com.wellsfargo.interview.dao.InterviewDao;
import com.wellsfargo.interview.dao.UserDao;
import com.wellsfargo.interview.entity.AttendeeEntity;
import com.wellsfargo.interview.entity.InterviewEntity;
import com.wellsfargo.interview.entity.UserEntity;
import com.wellsfargo.interview.exception.InterviewException;

@Service
public class AttendeeServiceImpl implements AttendeeService {
	
	@Autowired
	private AttendeeDao attendeeRepo;
	
	@Autowired
	private InterviewDao interviewRepo;
	
	@Autowired
	private UserDao userRepo;

	@Override
	@Transactional
	public AttendeeEntity add(AttendeeEntity attendee) throws InterviewException {
		if (attendee!=null)
		{
			if (attendeeRepo.existsById(attendee.getAttendeeId()))
			{
				throw new InterviewException("Attendee id already exists");
			}
			
			if (!userRepo.existsById(attendee.getUser().getUserId()))
			{
				throw new InterviewException("User doesn't exists");
			}
			if (!interviewRepo.existsById(attendee.getInterview().getInterviewId()))
			{
				throw new InterviewException("Interview id doesn't exists");
			}
			List<UserEntity> entities=null;
			entities=attendeeRepo.findAllinterviewId(attendee.getInterview());
			for(UserEntity e:entities)
			{
				if (e.getUserId()==attendee.getUser().getUserId())
				{
					throw new InterviewException("User has already been added to this interview");
				}
			}
			
			
			UserEntity usertoadd=attendee.getUser();
			InterviewEntity interviewtoadd=attendee.getInterview();
			
			attendee.setUser(usertoadd);
			attendee.setInterview(interviewtoadd);
			usertoadd.getAttendees().add(attendee);
			interviewtoadd.getAttendees().add(attendee);			
			attendeeRepo.save(attendee);			
			
		}
		return attendee;
	}

	@Override
	public List<UserEntity> getAllAttendees(int interview) {
		List<UserEntity> entities=null;
		InterviewEntity i=interviewRepo.findById(interview).orElse(null);
		if (i!=null)
		{
			entities=attendeeRepo.findAllinterviewId(i);
		}
		return entities;
	}
	
	
}
