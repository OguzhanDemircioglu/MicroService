package com.rentacar.api.user.business.requests.corporateCustomer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCorporateRequest {
	
	@NotNull
	private String id;
	
	@NotNull
	private String companyName;
	
	@NotNull
	private String taxNumber;
	
	@Email
	@NotNull
	@NotBlank
	private String email;
	
	@NotNull
	@NotBlank
	@Size(min=8 , max=20)
	private String password;
	
}
