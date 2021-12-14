package com.rentacar.api.user.business.concretes;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rentacar.api.user.DataAccess.UserDao;
import com.rentacar.api.user.business.abstracts.UserService;
import com.rentacar.api.user.business.requests.LoginRequestModel;
import com.rentacar.api.user.entities.UserEntity;

@Service
public class UserManager implements UserService {
	private UserDao userDao;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserManager(UserDao userRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDao = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	public LoginRequestModel getUserDetailsByEmail(String email) {
		UserEntity userEntity = this.userDao.getByEmail(email).get(0);
		if(userEntity == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new ModelMapper().map(userEntity, LoginRequestModel.class);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity user = (UserEntity) this.userDao.getByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Kullanıcı bulunamadı.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getEncryptedPassword(), true, true, true, true,
				new ArrayList<>());
	}
}
