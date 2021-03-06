package com.rentacar.api.user.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rentacar.api.user.business.abstracts.UserService;
import com.rentacar.api.user.business.requests.LoginRequestModel;
import com.rentacar.api.user.entities.UserEntity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private Environment environment;
	private UserService userService;
	
	public AuthenticationFilter(UserService userService,Environment environment, AuthenticationManager authenticationManager) {
		this.environment = environment;
		this.userService = userService;
		super.setAuthenticationManager(authenticationManager);
	}


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			LoginRequestModel credidentals = new ObjectMapper().readValue(request.getInputStream(), LoginRequestModel.class);
			
			return getAuthenticationManager()
					.authenticate(new UsernamePasswordAuthenticationToken(credidentals.getEmail(), credidentals.getPassword(), new ArrayList<>()));
		} catch (IOException e)  {
			throw new RuntimeException(e);
		}
	}
	
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		String userName = ((UserEntity)authResult.getPrincipal()).getEmail();
		LoginRequestModel userDetails = this.userService.getUserDetailsByEmail(userName);
		
		String token = Jwts.builder().setSubject(userDetails.getEmail()).setExpiration(new Date(System.currentTimeMillis()+Long.parseLong(this.environment.getProperty("token.expiration"))))
                .signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret")).compact();

        response.addHeader("token", token);
        response.addHeader("userId", userDetails.getId());
	}

}

