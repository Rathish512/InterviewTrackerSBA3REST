package com.wellsfargo.interview.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.interview.dao.InterviewDao;
import com.wellsfargo.interview.entity.InterviewEntity;
import com.wellsfargo.interview.exception.InterviewException;
import com.wellsfargo.interview.model.InterviewModel;

@Service
public class InterviewServiceImpl implements InterviewService{
	
	@Autowired
	private InterviewDao interviewRepo;
	
	
	private InterviewEntity toEntity(InterviewModel model) {
		return new InterviewEntity(model.getInterviewId(),model.getInterviewerName(),
				model.getInterviewName(),model.getUsersSkills(),model.getTime(),
				model.getDate(),model.getInterviewStatus(),model.getRemarks());
	}
	
	private InterviewModel toModel(InterviewEntity entity) {
		return new InterviewModel(entity.getInterviewId(),entity.getInterviewerName(),
				entity.getInterviewName(),entity.getUsersSkills(),entity.getTime(),
				entity.getDate(),entity.getInterviewStatus(),entity.getRemarks());
	}

	@Override
	@Transactional
	public InterviewModel add(InterviewModel interview) throws InterviewException {
		if(interviewRepo!=null) {
			if(interviewRepo.existsById(interview.getInterviewId())) {
				throw new InterviewException("Interview Id already used!");
			}
			
			interview = toModel(interviewRepo.save(toEntity(interview)));
		}
		return interview;
	}

	@Override
	@Transactional
	public InterviewModel save(InterviewModel interview) throws InterviewException {
		if(interview!=null) {
			if(!interviewRepo.existsById(interview.getInterviewId())) {
				throw new InterviewException("Interview Not Found");
			}
			
			interview = toModel(interviewRepo.save(toEntity(interview)));
		}
		return interview;
	}

	@Override
	@Transactional
	public boolean deleteInterview(int interviewId) throws InterviewException {
		if(!interviewRepo.existsById(interviewId)) {
			throw new InterviewException("Interview details Not Found");
		}
		
		interviewRepo.deleteById(interviewId);
		return true;
	}

	@Override
	public InterviewModel getInterview(int interviewId) {
		InterviewEntity entity = interviewRepo.findById(interviewId).orElse(null);
		return entity!=null?toModel(entity):null;
	}

	@Override
	public List<InterviewModel> getAllInterviews() {
		List<InterviewEntity> entities = interviewRepo.findAll();
		List<InterviewModel> models = null;
		if(entities!=null && !entities.isEmpty()) {
			models = entities.stream().map(e -> toModel(e)).collect(Collectors.toList());
		}
		return models;
	}

	@Override
	public List<InterviewModel> getAllInterviewByName(String name) {
		List<InterviewModel> models=null;
		List<InterviewEntity> entities=null;
		entities=interviewRepo.findAllinterviewName(name);
		if (entities==null || entities.isEmpty())
		{
			entities=interviewRepo.findAllinterviewName(name);
		}
		if (entities!=null && !entities.isEmpty()) {
			models=entities.stream().map(e->toModel(e)).collect(Collectors.toList());
		}
		
		return models;
	}

	@Override
	public Integer getTotalNoofinterviews() {
		return interviewRepo.findAll().size();
	}
	
	
}
