package com.quintrix.jfs.quintrixspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.quintrix.jfs.quintrixspring.models.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

}

