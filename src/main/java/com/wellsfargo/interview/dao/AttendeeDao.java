package com.wellsfargo.interview.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.interview.entity.AttendeeEntity;
import com.wellsfargo.interview.entity.InterviewEntity;
import com.wellsfargo.interview.entity.UserEntity;

@Repository
public interface AttendeeDao extends JpaRepository<AttendeeEntity,Integer>{

	@Query("SELECT A.User FROM AttendeeEntity A WHERE A.Interview=interview")
	List<UserEntity> findAllinterviewId(InterviewEntity interview);
}
