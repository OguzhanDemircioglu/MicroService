package com.rentacar.api.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.api.user.business.abstracts.UserService;
import com.rentacar.api.user.core.utilities.mapping.ModelMapperService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private UserService userService;
	private ModelMapperService modelMapperService;
	private Environment environment;
	@Autowired
	public UsersController(Environment environment ,UserService userService, ModelMapperService modelMapperService) {
		this.environment = environment;
		this.userService= userService;
		this.modelMapperService = modelMapperService; 
	}
	
	@GetMapping("/status/check")
    public String status() {
        return "working on : "+ environment.getProperty("local.server.port");
    }
}
