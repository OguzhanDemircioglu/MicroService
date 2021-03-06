package com.rentacar.api.user.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.api.user.business.abstracts.IndividualCustomerService;
import com.rentacar.api.user.business.dtos.IndividualCustomerSearchListDto;
import com.rentacar.api.user.business.dtos.IndividualCustomerSearchListDtoModel;
import com.rentacar.api.user.business.requests.individualCustomer.CreateIndividualRequest;
import com.rentacar.api.user.business.requests.individualCustomer.DeleteIndividualCustomerRequest;
import com.rentacar.api.user.business.requests.individualCustomer.UpdateIndividualCustomerRequest;
import com.rentacar.api.user.core.utilities.mapping.ModelMapperService;
import com.rentacar.api.user.core.utilities.result.DataResult;
import com.rentacar.api.user.core.utilities.result.Result;


@RestController
@RequestMapping("/api/individualCustomers/")
public class IndividualCustomersController {
	private IndividualCustomerService individualCustomerService;
	private ModelMapperService modelMapperService;
	private Environment environment;
	@Autowired
	public IndividualCustomersController(Environment environment, IndividualCustomerService individualCustomerService,ModelMapperService modelMapperService) {
		this.environment = environment;
		this.individualCustomerService = individualCustomerService;
		this.modelMapperService = modelMapperService; 
	}
	
	@GetMapping("/status/check")
    public String status() {
        return "working on : "+ environment.getProperty("local.server.port");
    }
	
	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateIndividualRequest createIndividualRequest) {
		IndividualCustomerSearchListDto individualCustomerSearchListDto = modelMapperService.forRequest()
				.map(createIndividualRequest, IndividualCustomerSearchListDto.class);
		return this.individualCustomerService.add(individualCustomerSearchListDto);
	}

	@GetMapping("all")
	public DataResult<List<IndividualCustomerSearchListDtoModel>> getAll() {
		return this.individualCustomerService.getAll();

	}

	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
		IndividualCustomerSearchListDto individualCustomerSearchListDto = modelMapperService.forRequest()
				.map(updateIndividualCustomerRequest, IndividualCustomerSearchListDto.class);
		return this.individualCustomerService.add(individualCustomerSearchListDto);
	}

	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
		return this.individualCustomerService.delete(deleteIndividualCustomerRequest);
	}
	
	

}
