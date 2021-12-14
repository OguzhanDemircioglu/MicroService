package com.rentacar.api.user.business.dtos;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CorporateCustomerSearchListDto {
	private String id;
	private String companyName;
	private String taxNumber;
	private String email;
	private String password;
	private String encryptedPassword;
}
