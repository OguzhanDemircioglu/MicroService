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

import com.rentacar.api.rental.business.abstracts.CarService;
import com.rentacar.api.rental.business.dtos.CarDto;
import com.rentacar.api.rental.core.utilities.result.DataResult;
import com.rentacar.api.rental.core.utilities.result.Result;
import com.rentacar.api.rental.models.car.CreateCarRequestModel;
import com.rentacar.api.rental.models.car.DeleteCarRequestModel;
import com.rentacar.api.rental.models.car.UpdateCarRequestModel;

@RestController
@RequestMapping("api/cars")
public class CarsController {
	private CarService carService;
	@Autowired
	public CarsController(CarService carService) {
		this.carService = carService;
	}
	@GetMapping("all")
	public DataResult<List<CarDto>>  getAll(){	
		return carService.getAll();
	}
	@PostMapping("add")
	public Result add(@RequestBody @Valid CreateCarRequestModel createCarRequestModel) {
		return this.carService.add(createCarRequestModel);
	}
	@PutMapping("update")
	public Result update(@RequestBody @Valid UpdateCarRequestModel updateCarRequestModel) {
		return this.carService.update(updateCarRequestModel);
	}
	@DeleteMapping("delete")
	public Result delete(@RequestBody @Valid DeleteCarRequestModel deleteCarRequestModel) {
		return this.carService.delete(deleteCarRequestModel);
	}
}
