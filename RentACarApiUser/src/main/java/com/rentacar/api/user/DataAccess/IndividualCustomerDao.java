package com.rentacar.api.user.DataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.api.user.entities.IndividualCustomer;



public interface IndividualCustomerDao extends JpaRepository<IndividualCustomer, String>{
   

}
