package com.rentacar.api.rental.models.color;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateColorRequestModel {
	@JsonIgnore
	private int colorId;
	@NotNull
	@NotBlank
	private String colorName;
}
