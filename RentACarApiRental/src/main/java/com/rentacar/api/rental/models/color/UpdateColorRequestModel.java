package com.rentacar.api.rental.models.color;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequestModel {
	private int colorId;
	@NotNull
	@NotBlank
	private String colorName;
}
