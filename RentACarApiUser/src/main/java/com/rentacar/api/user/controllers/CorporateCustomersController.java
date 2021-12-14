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

import com.rentacar.api.user.business.abstracts.CorporateCustomerService;
import com.rentacar.api.user.business.dtos.CorporateCustomerSearchListDto;
import com.rentacar.api.user.business.dtos.CorporateCustomerSearchListDtoModel;
import com.rentacar.api.user.business.requests.corporateCustomer.CreateCorporateRequest;
import com.rentacar.api.user.business.requests.corporateCustomer.DeleteCorporateRequest;
import com.rentacar.api.user.business.requests.corporateCustomer.UpdateCorporateRequest;
import com.rentacar.api.user.core.utilities.mapping.ModelMapperService;
import com.rentacar.api.user.core.utilities.result.DataResult;
import com.rentacar.api.user.core.utilities.result.Result;


@RestController
@RequestMapping("/api/corporateCustomers/")
public class CorporateCustomersController {
	private CorporateCustomerService corporateCustomerService;
	private ModelMapperService modelMapperService;
	private Environment environment;
	
	@Autowired
	public CorporateCustomersController(Environment environment, CorporateCustomerService corporateCustomerService,ModelMapperService modelMapperService) {
		super();
		this.environment = environment;
		this.corporateCustomerService = corporateCustomerService;
		this.modelMapperService = modelMapperService;
	}
	
	@GetMapping("/status/check")
    public String status() {
        return "working on : "+ environment.getProperty("local.server.port");
    }
	
	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateCorporateRequest createCorporateRequest) {
		CorporateCustomerSearchListDto corporateCustomerSearchListDto = modelMapperService.forRequest()
				.map(createCorporateRequest, CorporateCustomerSearchListDto.class);
		return this.corporateCustomerService.add(corporateCustomerSearchListDto);
	}
	@GetMapping("all")
	public DataResult<List<CorporateCustomerSearchListDtoModel>> getAll(){
		return this.corporateCustomerService.getAll();
		
	}
	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateCorporateRequest updateCorporateRequest) {
		CorporateCustomerSearchListDto corporateCustomerSearchListDto = modelMapperService.forRequest()
				.map(updateCorporateRequest, CorporateCustomerSearchListDto.class);
		return this.corporateCustomerService.update(corporateCustomerSearchListDto);
		
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteCorporateRequest deleteCorporateRequest) {
		
		return this.corporateCustomerService.delete(deleteCorporateRequest);
	}
}
