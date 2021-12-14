package com.rentacar.api.rental.dataAccess;

import org.springframework.data.repository.CrudRepository;

import com.rentacar.api.rental.entities.Brand;

public interface BrandRepository extends CrudRepository<Brand, Integer>{

}
