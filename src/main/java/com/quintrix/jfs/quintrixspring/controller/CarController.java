package com.quintrix.jfs.quintrixspring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.service.CarService;

@RestController
public class CarController {

  @Autowired
  private CarService carService;

  @RequestMapping(method = RequestMethod.GET, value = "/cars")
  List<Car> getCars(@RequestParam(name = "make", required = false) String make) {
    return carService.getCarsList();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/cars/{id}")
  Car getCarDetails(@PathVariable("id") Long id) {
    return carService.getCar(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/cars")
  Car addCar(@RequestBody Car car) {
    return carService.addCar(car);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/cars/{id}")
  void updateCar(@RequestBody Car car, @PathVariable("id") Long id) {
    carService.updateCar(car, id);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/cars/{id}")
  void deleteCar(@PathVariable("id") Long id) {
    carService.deleteCar(id);
  }
}

