package com.rentacar.api.rental.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.api.rental.business.abstracts.CarService;
import com.rentacar.api.rental.business.dtos.CarDto;
import com.rentacar.api.rental.core.utilities.mapping.ModelMapperService;
import com.rentacar.api.rental.core.utilities.result.DataResult;
import com.rentacar.api.rental.core.utilities.result.Result;
import com.rentacar.api.rental.core.utilities.result.SuccessDataResult;
import com.rentacar.api.rental.core.utilities.result.SuccessResult;
import com.rentacar.api.rental.dataAccess.CarRepository;
import com.rentacar.api.rental.entities.Car;
import com.rentacar.api.rental.models.car.CreateCarRequestModel;
import com.rentacar.api.rental.models.car.DeleteCarRequestModel;
import com.rentacar.api.rental.models.car.UpdateCarRequestModel;

@Service
public class CarManager implements CarService{
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	@Autowired
	public CarManager(CarRepository carRepository, ModelMapperService modelMapperService) {
		this.carRepository = carRepository;
		this.modelMapperService = modelMapperService;
	}
	@Override
	public DataResult<List<CarDto>> getAll() {
		 List<Car> cars = new ArrayList<>();
		    carRepository.findAll().forEach(cars::add);
		    
		    List<CarDto> response = cars.stream()
	                .map(car -> modelMapperService.forDto().map(car, CarDto.class))
	                .collect(Collectors.toList());

		    return new SuccessDataResult<List<CarDto>>(response);
	}
	@Override
	public Result add(CreateCarRequestModel createCarRequestModel) {
		Car car = modelMapperService.forDto().map(createCarRequestModel, Car.class);

		this.carRepository.save(car);
		return new SuccessResult( "car added");
	}
	@Override
	public Result delete(DeleteCarRequestModel carRequestModel) {
		this.carRepository.deleteById(carRequestModel.getId());

		return new SuccessResult( "car deleted");
	}
	@Override
	public Result update(UpdateCarRequestModel updateCarRequestModel) {
		Car car = modelMapperService.forDto().map(updateCarRequestModel, Car.class);

		this.carRepository.save(car);
		return new SuccessResult( "car updated");
	}
	

}
