package com.org.cardatabase.repository;

import com.org.cardatabase.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}
