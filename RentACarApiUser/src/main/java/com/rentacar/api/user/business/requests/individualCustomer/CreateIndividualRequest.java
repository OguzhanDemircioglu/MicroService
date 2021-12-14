package com.rentacar.api.user.business.requests.individualCustomer;

import java.time.LocalDate;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateIndividualRequest {
	@JsonIgnore
	private String id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
    @NotNull
	private LocalDate birthDay;
	
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min=8 , max=20)
	private String password;
	

}
