package com.rentacar.api.rental.dataAccess;

import org.springframework.data.repository.CrudRepository;

import com.rentacar.api.rental.entities.Color;

public interface ColorRepository extends CrudRepository<Color, Integer> {

}
