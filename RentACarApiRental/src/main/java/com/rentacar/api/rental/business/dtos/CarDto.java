package com.rentacar.api.rental.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
	private int id;

	private int dailyPrice;

	private String description;

	private int modelYear;
	
	private int brandId;
	
	private int colorId;
}
