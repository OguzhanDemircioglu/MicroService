package com.rentacar.api.user.business.abstracts;

import java.util.List;

import com.rentacar.api.user.business.dtos.IndividualCustomerSearchListDto;
import com.rentacar.api.user.business.dtos.IndividualCustomerSearchListDtoModel;
import com.rentacar.api.user.business.requests.individualCustomer.DeleteIndividualCustomerRequest;
import com.rentacar.api.user.core.utilities.result.DataResult;
import com.rentacar.api.user.core.utilities.result.Result;

public interface IndividualCustomerService {
	Result add(IndividualCustomerSearchListDto individualCustomerSearchListDto);
	Result update(IndividualCustomerSearchListDto individualCustomerSearchListDto);
	Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest);
	DataResult<List<IndividualCustomerSearchListDtoModel>> getAll();


}
