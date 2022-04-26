package com.quintrix.jfs.quintrixspring.service;

import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.models.ClientCar;
import com.quintrix.jfs.quintrixspring.models.GetCarsResponse;

public interface CarsService {

  ClientCar getCarDetailsById(Long id);

  void deleteCar(Long id);

  void updateCar(Car car, Long id);

  ClientCar addCar(Car car);

  ClientCar getCar(Long id);

  GetCarsResponse getCarsList(String make);

}

