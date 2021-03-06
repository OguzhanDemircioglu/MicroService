package com.rentacar.api.user.business.concretes;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rentacar.api.user.DataAccess.CorporateCustomerDao;
import com.rentacar.api.user.business.abstracts.CorporateCustomerService;
import com.rentacar.api.user.business.dtos.CorporateCustomerSearchListDto;
import com.rentacar.api.user.business.dtos.CorporateCustomerSearchListDtoModel;
import com.rentacar.api.user.business.requests.corporateCustomer.DeleteCorporateRequest;
import com.rentacar.api.user.core.utilities.mapping.ModelMapperService;
import com.rentacar.api.user.core.utilities.result.DataResult;
import com.rentacar.api.user.core.utilities.result.Result;
import com.rentacar.api.user.core.utilities.result.SuccessDataResult;
import com.rentacar.api.user.core.utilities.result.SuccessResult;
import com.rentacar.api.user.entities.CorporateCustomer;



@Service
public class CorporateCustomerManager implements CorporateCustomerService {
	private CorporateCustomerDao corporateCustomerDao;
	private ModelMapperService modelMapperService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	@Autowired
	public CorporateCustomerManager(CorporateCustomerDao corporateCustomerDao, ModelMapperService modelMapperService,BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.corporateCustomerDao = corporateCustomerDao;
		this.modelMapperService = modelMapperService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		
		
	}

	@Override
	public Result add(CorporateCustomerSearchListDto corporateCustomerSearchListDto) {
		corporateCustomerSearchListDto.setId(UUID.randomUUID().toString());
		corporateCustomerSearchListDto.setEncryptedPassword(this.bCryptPasswordEncoder.encode(corporateCustomerSearchListDto.getPassword()));
		CorporateCustomer corporateCustomer=modelMapperService.forRequest().map(corporateCustomerSearchListDto, CorporateCustomer.class);
		corporateCustomerDao.save(corporateCustomer);
		
		return new SuccessResult("Corporate customer added.");
	}

	@Override
	public Result update(CorporateCustomerSearchListDto corporateCustomerSearchListDto) {
		corporateCustomerSearchListDto.setEncryptedPassword(this.bCryptPasswordEncoder.encode(corporateCustomerSearchListDto.getPassword()));
		CorporateCustomer corporateCustomer=modelMapperService.forRequest().map(corporateCustomerSearchListDto, CorporateCustomer.class);
		corporateCustomerDao.save(corporateCustomer);
		
		return new SuccessResult("Corporate customer updated.");
	}

	@Override
	public Result delete(DeleteCorporateRequest deleteCorporateRequest) {
		
		CorporateCustomer corporateCustomer = modelMapperService.forRequest().map(deleteCorporateRequest, CorporateCustomer.class);
		this.corporateCustomerDao.delete(corporateCustomer);
		return new SuccessResult("Corporate customer deleted.");
	}

	@Override
	public DataResult<List<CorporateCustomerSearchListDtoModel>> getAll() {
		List<CorporateCustomer> result = this.corporateCustomerDao.findAll();
		List<CorporateCustomerSearchListDtoModel> response = result.stream().map(corporateCustomer -> modelMapperService.forDto()
				.map(corporateCustomer, CorporateCustomerSearchListDtoModel.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<CorporateCustomerSearchListDtoModel>>(response);
	}



//	private Result existsByUserId(int userId) {
//		boolean result = this.corporateCustomerDao.existsById(userId);
//		if (result == false) {
//			return new ErrorResult("B??yle bir kullan??c?? id'si yok. Bu y??zden bir crud operasonlar?? yapamazs??n??z.");
//		}
//		return new SuccessResult();
//	}
//	private Result checkUserHasNoCreditCard(int userId) {
//		if (this.creditCardService.checkUserHasNoCreditCard(userId).isSuccess()) {
//			return new ErrorResult("Kullan??c??n??n kay??tl?? kredi kart?? varken silme i??lemi yapamazs??n??z.");
//		}
//		return new SuccessResult();
//
//	}
//	private Result checkUserHasNoRental(int userId) {
//		if (this.rentalService.checkUserHasNoRental(userId).isSuccess()) {
//			return new ErrorResult("Kullan??c??n??n kay??tl?? Kiralama i??lemi varken kullan??c?? silinemez.");
//		}
//		return new SuccessResult();
//
//	}
}
