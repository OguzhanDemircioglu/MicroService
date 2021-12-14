package com.rentacar.api.rental.dataAccess;

import org.springframework.data.repository.CrudRepository;

import com.rentacar.api.rental.entities.Car;

public interface CarRepository extends CrudRepository<Car, Integer>{

}
