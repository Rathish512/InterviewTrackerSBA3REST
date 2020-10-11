package com.wellsfargo.interview.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.interview.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer>{

	@Query("SELECT U FROM UserEntity U WHERE U.userId=:id")
	List<UserEntity> findAllUsersById(Integer id);
}
