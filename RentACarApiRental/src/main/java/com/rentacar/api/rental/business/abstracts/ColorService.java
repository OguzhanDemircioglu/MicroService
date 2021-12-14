package com.rentacar.api.rental.business.abstracts;

import java.util.List;

import com.rentacar.api.rental.business.dtos.ColorDto;
import com.rentacar.api.rental.core.utilities.result.DataResult;
import com.rentacar.api.rental.core.utilities.result.Result;
import com.rentacar.api.rental.models.color.CreateColorRequestModel;
import com.rentacar.api.rental.models.color.DeleteColorRequestModel;
import com.rentacar.api.rental.models.color.UpdateColorRequestModel;

public interface ColorService {
	DataResult<List<ColorDto>> getAll();
	Result add(CreateColorRequestModel createColorRequestModel);
	Result update(UpdateColorRequestModel updateColorRequestModel);
	Result delete(DeleteColorRequestModel deleteColorRequestModel);
}
