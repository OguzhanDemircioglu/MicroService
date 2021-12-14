package com.rentacar.api.rental.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.api.rental.business.abstracts.BrandService;
import com.rentacar.api.rental.business.dtos.BrandDto;
import com.rentacar.api.rental.core.utilities.result.DataResult;
import com.rentacar.api.rental.core.utilities.result.Result;
import com.rentacar.api.rental.models.brand.CreateBrandRequestModel;
import com.rentacar.api.rental.models.brand.DeleteBrandRequestModel;
import com.rentacar.api.rental.models.brand.UpdateBrandRequestModel;

@RestController
@RequestMapping("api/brands")
public class BrandsController {
private BrandService brandService;
	
    @Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
    
	@GetMapping("all")
	public DataResult<List<BrandDto>> getAll(){
				
		return this.brandService.getAll();
	}
	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateBrandRequestModel createBrandRequestModel) {
		return this.brandService.add(createBrandRequestModel);
		
	}
	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateBrandRequestModel updateBrandRequestModel) {
		return this.brandService.update(updateBrandRequestModel);
	
	}
	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteBrandRequestModel deleteBrandRequestModel) {
		return this.brandService.delete(deleteBrandRequestModel);
	
	}
}
