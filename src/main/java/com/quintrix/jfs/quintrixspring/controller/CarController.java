package com.quintrix.jfs.quintrixspring.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.models.ClientCar;
import com.quintrix.jfs.quintrixspring.models.GetCarsResponse;
import com.quintrix.jfs.quintrixspring.service.CarsService;

@RestController
public class CarController {

  private static final Logger logger = LoggerFactory.getLogger(CarController.class);

  @Autowired
  CarsService carService;

  @RequestMapping(method = RequestMethod.GET, value = "/cars")
  GetCarsResponse getCars(@RequestParam(name = "make", required = false) String make) {
    logger.debug("Request all cars");
    return carService.getCarsList(make);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/cars/{id}")
  ClientCar getCarDetails(@PathVariable("id") Long id) {
    logger.debug("Request car by id");
    return carService.getCar(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/cars")
  ClientCar addCar(@RequestBody String carStr) {
    logger.debug("Add a new cars");
    System.out.println(carStr);

    ObjectMapper objectMapper = new ObjectMapper();
    Car car;
    try {
      car = objectMapper.readValue(carStr, Car.class);
      return carService.addCar(car);
    } catch (JsonMappingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (JsonProcessingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/cars/{id}")
  void updateCar(@RequestBody Car car, @PathVariable("id") Long id) {
    logger.debug("Update a car by id");
    carService.updateCar(car, id);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/cars/{id}")
  void deleteCar(@PathVariable("id") Long id) {
    logger.debug("Delete a car");
    carService.deleteCar(id);
  }

  @ExceptionHandler(Exception.class)
  public void handleExceptions() {

  }
}

