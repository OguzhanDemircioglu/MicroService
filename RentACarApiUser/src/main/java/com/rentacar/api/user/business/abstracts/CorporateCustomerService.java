package com.rentacar.api.user.business.abstracts;

import java.util.List;

import com.rentacar.api.user.business.dtos.CorporateCustomerSearchListDto;
import com.rentacar.api.user.business.dtos.CorporateCustomerSearchListDtoModel;
import com.rentacar.api.user.business.requests.corporateCustomer.DeleteCorporateRequest;
import com.rentacar.api.user.core.utilities.result.DataResult;
import com.rentacar.api.user.core.utilities.result.Result;


public interface CorporateCustomerService {
	
	Result add(CorporateCustomerSearchListDto corporateCustomerSearchListDto);
	Result update(CorporateCustomerSearchListDto corporateCustomerSearchListDto);
	Result delete(DeleteCorporateRequest deleteCorporateRequest);
	DataResult<List<CorporateCustomerSearchListDtoModel>> getAll();

	

}
