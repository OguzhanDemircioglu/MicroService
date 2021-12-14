package com.rentacar.api.rental.models.car;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequestModel {
	@JsonIgnore
	private int id;
	
	@NotNull
    private int colorId;

    @NotNull
    private int brandId;
    
    @NotNull
    private String description;

    @NotNull
    @Min(1980)
    @Max(2022)
    private int modelYear;

    @NotNull
    @Min(100)
    @Max(10000)
    private int dailyPrice;
}
