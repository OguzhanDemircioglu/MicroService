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

import com.rentacar.api.rental.business.abstracts.ColorService;
import com.rentacar.api.rental.business.dtos.ColorDto;
import com.rentacar.api.rental.core.utilities.result.DataResult;
import com.rentacar.api.rental.core.utilities.result.Result;
import com.rentacar.api.rental.models.color.CreateColorRequestModel;
import com.rentacar.api.rental.models.color.DeleteColorRequestModel;
import com.rentacar.api.rental.models.color.UpdateColorRequestModel;

@RestController
@RequestMapping("api/colors")
public class ColorsController {
private ColorService colorService;
    
	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}
	
	@GetMapping("all")
	public DataResult<List<ColorDto>> getAll(){
		return this.colorService.getAll();	
	}
	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateColorRequestModel createColorRequestModel) {
		return this.colorService.add(createColorRequestModel);
	}
	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateColorRequestModel updateColorRequestModel) {	
		return this.colorService.update(updateColorRequestModel);
	}
	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteColorRequestModel deleteColorRequestModel) {
		return this.colorService.delete(deleteColorRequestModel);
	}
}
