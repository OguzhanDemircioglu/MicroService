package com.rentacar.api.rental.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.api.rental.business.abstracts.ColorService;
import com.rentacar.api.rental.business.dtos.ColorDto;
import com.rentacar.api.rental.core.utilities.mapping.ModelMapperService;
import com.rentacar.api.rental.core.utilities.result.DataResult;
import com.rentacar.api.rental.core.utilities.result.Result;
import com.rentacar.api.rental.core.utilities.result.SuccessDataResult;
import com.rentacar.api.rental.core.utilities.result.SuccessResult;
import com.rentacar.api.rental.dataAccess.ColorRepository;
import com.rentacar.api.rental.entities.Color;
import com.rentacar.api.rental.models.color.CreateColorRequestModel;
import com.rentacar.api.rental.models.color.DeleteColorRequestModel;
import com.rentacar.api.rental.models.color.UpdateColorRequestModel;


@Service
public class ColorManager implements ColorService {
	private ColorRepository colorRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public ColorManager(ColorRepository colorRepository, ModelMapperService modelMapperService) {
		this.colorRepository = colorRepository;
		this.modelMapperService = modelMapperService;
	}
	
	@Override
	public DataResult<List<ColorDto>> getAll() {
		
		    List<Color> colors = new ArrayList<>();
		    colorRepository.findAll().forEach(colors::add);
		    
		    List<ColorDto> response = colors.stream()
	                .map(color -> modelMapperService.forDto().map(color, ColorDto.class))
	                .collect(Collectors.toList());

		    return new SuccessDataResult<List<ColorDto>>(response);
	}
	
	@Override
	public Result add(CreateColorRequestModel createColorRequestModel) {

		Color color = modelMapperService.forDto().map(createColorRequestModel, Color.class);

		this.colorRepository.save(color);
		return new SuccessResult( "color added");

	}

	@Override
	public Result update(UpdateColorRequestModel updateColorRequestModel) {

		Color color = modelMapperService.forDto().map(updateColorRequestModel, Color.class);

		this.colorRepository.save(color);
		return new SuccessResult( "color updated");
	}

	@Override
	public Result delete(DeleteColorRequestModel deleteColorRequestModel) {

		this.colorRepository.deleteById(deleteColorRequestModel.getId());

		return new SuccessResult( "color deleted");
	}

//	@Override
//	public DataResult<ColorDto> getById(int colorId) {
//
//		Color color = this.colorRepository.findById(colorId).get();
//		
//		return new SuccessDataResult<ColorDto>(modelMapperService.forDto().map(color, ColorDto.class), "color listed");
//	}
}
