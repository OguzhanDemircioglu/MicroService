package com.rentacar.api.user.business.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualCustomerSearchListDtoModel {
	private String id;
	private String firstName;
	private String lastName;
	private LocalDate birthday;
	private String email;
	private String encryptedPassword;
}
