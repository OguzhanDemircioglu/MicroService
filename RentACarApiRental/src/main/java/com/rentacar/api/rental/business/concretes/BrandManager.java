package com.rentacar.api.rental.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.api.rental.business.abstracts.BrandService;
import com.rentacar.api.rental.business.dtos.BrandDto;
import com.rentacar.api.rental.core.utilities.mapping.ModelMapperService;
import com.rentacar.api.rental.core.utilities.result.DataResult;
import com.rentacar.api.rental.core.utilities.result.Result;
import com.rentacar.api.rental.core.utilities.result.SuccessDataResult;
import com.rentacar.api.rental.core.utilities.result.SuccessResult;
import com.rentacar.api.rental.dataAccess.BrandRepository;
import com.rentacar.api.rental.entities.Brand;
import com.rentacar.api.rental.models.brand.CreateBrandRequestModel;
import com.rentacar.api.rental.models.brand.DeleteBrandRequestModel;
import com.rentacar.api.rental.models.brand.UpdateBrandRequestModel;
@Service
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	@Autowired
	public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService) {
		this.brandRepository = brandRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<BrandDto>> getAll() {
		List<Brand> brands = new ArrayList<>();
		brandRepository.findAll().forEach(brands::add);
	    
	    List<BrandDto> response = brands.stream()
                .map(brand -> modelMapperService.forDto().map(brand, BrandDto.class))
                .collect(Collectors.toList());

	    return new SuccessDataResult<List<BrandDto>>(response);
	}

	@Override
	public Result add(CreateBrandRequestModel createBrandRequestModel) {
		Brand brand = modelMapperService.forDto().map(createBrandRequestModel, Brand.class);

		this.brandRepository.save(brand);
		return new SuccessResult( "brand added");
	}

	@Override
	public Result update(UpdateBrandRequestModel updateBrandRequestModel) {
		Brand brand = modelMapperService.forDto().map(updateBrandRequestModel, Brand.class);

		this.brandRepository.save(brand);
		return new SuccessResult( "brand added");
	}

	@Override
	public Result delete(DeleteBrandRequestModel deleteBrandRequestModel) {
		this.brandRepository.deleteById(deleteBrandRequestModel.getId());

		return new SuccessResult( "brand deleted");
	}

}
