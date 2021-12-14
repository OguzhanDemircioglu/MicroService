package com.rentacar.api.rental.models.brand;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequestModel {
	private int brandId;
	@NotBlank
	@NotNull
	private String brandName;
}
