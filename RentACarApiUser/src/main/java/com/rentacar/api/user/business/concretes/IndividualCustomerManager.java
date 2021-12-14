package com.rentacar.api.user.business.concretes;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rentacar.api.user.DataAccess.IndividualCustomerDao;
import com.rentacar.api.user.business.abstracts.IndividualCustomerService;
import com.rentacar.api.user.business.dtos.IndividualCustomerSearchListDto;
import com.rentacar.api.user.business.dtos.IndividualCustomerSearchListDtoModel;
import com.rentacar.api.user.business.requests.individualCustomer.DeleteIndividualCustomerRequest;
import com.rentacar.api.user.core.utilities.mapping.ModelMapperService;
import com.rentacar.api.user.core.utilities.result.DataResult;
import com.rentacar.api.user.core.utilities.result.Result;
import com.rentacar.api.user.core.utilities.result.SuccessDataResult;
import com.rentacar.api.user.core.utilities.result.SuccessResult;
import com.rentacar.api.user.entities.IndividualCustomer;

@Service
public class IndividualCustomerManager implements IndividualCustomerService {
    private IndividualCustomerDao individualCustomerDao;
    private ModelMapperService modelMapperService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    


    @Autowired
    public IndividualCustomerManager(IndividualCustomerDao individualCustomerDao, ModelMapperService modelMapperService,BCryptPasswordEncoder bCryptPasswordEncoder) {
        super();
        this.individualCustomerDao = individualCustomerDao;
        this.modelMapperService = modelMapperService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    @Override
    public Result add(IndividualCustomerSearchListDto individualCustomerSearchListDto) {
    	individualCustomerSearchListDto.setId(UUID.randomUUID().toString());
    	individualCustomerSearchListDto.setEncryptedPassword(this.bCryptPasswordEncoder.encode(individualCustomerSearchListDto.getPassword()));
    	IndividualCustomer individualCustomer=modelMapperService.forRequest().map(individualCustomerSearchListDto, IndividualCustomer.class);
    	individualCustomerDao.save(individualCustomer);
		
		return new SuccessResult("Individual customer added.");
    }

    @Override
    public Result update(IndividualCustomerSearchListDto individualCustomerSearchListDto) {
    	
    	individualCustomerSearchListDto.setEncryptedPassword(this.bCryptPasswordEncoder.encode(individualCustomerSearchListDto.getPassword()));
    	IndividualCustomer individualCustomer=modelMapperService.forRequest().map(individualCustomerSearchListDto, IndividualCustomer.class);
    	individualCustomerDao.save(individualCustomer);
		
		return new SuccessResult("Individual customer added.");
    }

    @Override
    public Result delete(DeleteIndividualCustomerRequest deleteIndividualCustomerRequest) {
        
        IndividualCustomer individualCustomer = modelMapperService.forRequest().map(deleteIndividualCustomerRequest, IndividualCustomer.class);
        this.individualCustomerDao.delete(individualCustomer);
        return new SuccessResult("Individual customer deleted.");
    }

    @Override
    public DataResult<List<IndividualCustomerSearchListDtoModel>> getAll() {

        List<IndividualCustomer> individualCustomers = this.individualCustomerDao.findAll();
        List<IndividualCustomerSearchListDtoModel> response = individualCustomers.stream().map(individualCustomer -> modelMapperService.forDto()
                .map(individualCustomer, IndividualCustomerSearchListDtoModel.class)).collect(Collectors.toList());
//        if (response.size() == 0) {
//            return new ErrorDataResult<List<IndividualCustomerSearchListDto>>(null, "Kayıtlı Bireysel Müşteri Bulunamadı.");
//        }
        return new SuccessDataResult<List<IndividualCustomerSearchListDtoModel>>(response);
    }

//    private Result checkUserHasNoCreditCard(int userId) {
//        if (this.creditCardService.checkUserHasNoCreditCard(userId).isSuccess()) {
//            return new ErrorResult("Kullanıcının kayıtlı kredi kartı varken silme işlemi yapamazsınız.");
//        }
//        return new SuccessResult();
//
//    }
//    private Result checkUserHasNoRental(int userId) {
//        if (this.rentalService.checkUserHasNoRental(userId).isSuccess()) {
//            return new ErrorResult("Kullanıcının kayıtlı Kiralama işlemi varken kullanıcı silinemez.");
//        }
//        return new SuccessResult();
//
//    }
//
//
//    private Result existsByUserId(int userId) {
//        boolean result = this.customerDao.existsById(userId);
//        if (result == false) {
//            return new ErrorResult("Böyle bir kullanıcı id'si yok. Bu yüzden bir crud operasonları yapamazsınız.");
//        }
//        return new SuccessResult();
//    }




}
