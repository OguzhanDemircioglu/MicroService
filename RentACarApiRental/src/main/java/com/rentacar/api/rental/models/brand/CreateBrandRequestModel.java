package com.rentacar.api.rental.models.brand;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequestModel {
	@JsonIgnore
	private int brandId;
	@NotNull
	@NotBlank
	private String brandName;

}
