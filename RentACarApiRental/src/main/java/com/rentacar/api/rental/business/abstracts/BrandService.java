package com.rentacar.api.rental.business.abstracts;

import java.util.List;

import com.rentacar.api.rental.business.dtos.BrandDto;
import com.rentacar.api.rental.core.utilities.result.DataResult;
import com.rentacar.api.rental.core.utilities.result.Result;
import com.rentacar.api.rental.models.brand.UpdateBrandRequestModel;
import com.rentacar.api.rental.models.brand.CreateBrandRequestModel;
import com.rentacar.api.rental.models.brand.DeleteBrandRequestModel;

public interface BrandService {
	DataResult<List<BrandDto>> getAll();
	Result add(CreateBrandRequestModel createBrandRequestModel);
	Result update(UpdateBrandRequestModel updateBrandRequestModel);
	Result delete(DeleteBrandRequestModel deleteBrandRequestModel);
}
