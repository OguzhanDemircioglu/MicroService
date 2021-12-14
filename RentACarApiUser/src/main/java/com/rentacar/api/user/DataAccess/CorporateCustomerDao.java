package com.rentacar.api.user.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.api.user.entities.CorporateCustomer;



public interface CorporateCustomerDao extends JpaRepository<CorporateCustomer, String> {



}
