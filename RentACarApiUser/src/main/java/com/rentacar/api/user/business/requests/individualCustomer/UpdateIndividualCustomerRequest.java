package com.rentacar.api.user.business.requests.individualCustomer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateIndividualCustomerRequest {
	@NotNull
	private String id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
    @NotNull
	private String birthDay;
	
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String password;
	


}
