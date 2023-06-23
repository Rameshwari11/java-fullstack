package com.cgi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cgi.entity.UserEntity;


public interface UserEntityRepository  extends JpaRepository<UserEntity,Integer>{
	
	@Query
	public UserEntity findByUserId(String userid);
	
	@Query
	public UserEntity findByEmail(String email);

}
