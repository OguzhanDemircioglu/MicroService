package com.rentacar.api.user.business.requests.corporateCustomer;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeleteCorporateRequest {
	@NotNull
	private String id;
	
}
