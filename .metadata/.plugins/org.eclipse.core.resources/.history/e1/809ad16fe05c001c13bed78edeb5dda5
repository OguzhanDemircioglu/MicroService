package com.rentacar.api.user.DataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.api.user.business.requests.LoginRequestModel;
import com.rentacar.api.user.entities.UserEntity;


public interface UserDao extends JpaRepository<UserEntity, String>{
	List<UserEntity> getByEmail(String email);//user
	boolean existsByEmail(String email);
	LoginRequestModel getUserDetailsByEmail(String email);
	
}
