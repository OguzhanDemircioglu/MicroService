package com.rentacar.api.rental.business.abstracts;

import java.util.List;

import com.rentacar.api.rental.business.dtos.CarDto;
import com.rentacar.api.rental.core.utilities.result.DataResult;
import com.rentacar.api.rental.core.utilities.result.Result;
import com.rentacar.api.rental.models.car.CreateCarRequestModel;
import com.rentacar.api.rental.models.car.DeleteCarRequestModel;
import com.rentacar.api.rental.models.car.UpdateCarRequestModel;

public interface CarService {
	DataResult<List<CarDto>> getAll();
	Result add(CreateCarRequestModel createCarRequestModel);
	Result delete(DeleteCarRequestModel carRequestModel);
	Result update(UpdateCarRequestModel updateCarRequestModel);
}
