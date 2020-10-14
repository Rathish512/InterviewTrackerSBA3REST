package com.wellsfargo.interview.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.interview.entity.InterviewEntity;

@Repository
public interface InterviewDao extends JpaRepository<InterviewEntity, Integer>{

	List<InterviewEntity> findAllByInterviewStatus(String status);
	
	@Query("SELECT I FROM InterviewEntity I WHERE I.interviewId=:id")
	List<InterviewEntity> findAllInterviewsById(Integer id);
	
	@Query("SELECT N FROM InterviewEntity N WHERE N.interviewName=:interviewName")
	List<InterviewEntity> findAllinterviewName(String interviewName);
}
