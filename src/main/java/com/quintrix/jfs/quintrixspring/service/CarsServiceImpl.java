package com.quintrix.jfs.quintrixspring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quintrix.jfs.quintrixspring.exception.CarNotFoundException;
import com.quintrix.jfs.quintrixspring.models.Car;
import com.quintrix.jfs.quintrixspring.models.ClientCar;
import com.quintrix.jfs.quintrixspring.models.GetCarsResponse;
import com.quintrix.jfs.quintrixspring.repository.CarRepository;
import com.quintrix.jfs.quintrixspring.restservice.AgentService;

@Service
public class CarsServiceImpl implements CarsService {
  private List<Car> carsList = new ArrayList<>(
      Arrays.asList(new Car(1L, "Ford", "SUV", 2011), new Car(2L, "Honda", "SUV", 2005),
          new Car(3L, "Honda", "Sedan", 2012), new Car(4L, "Volvo", "Truck", 2015)));

  @Autowired
  private CarRepository carRepository;

  @Autowired
  private AgentService agentService;

  @Override
  public GetCarsResponse getCarsList(String make) {
    GetCarsResponse getCarsResponse = new GetCarsResponse();
    if (make != null) {
      getCarsResponse.setAvailableCarsList(carsList.stream().filter(c -> c.getMake().equals(make))
          .map(c -> new ClientCar(c.getMake(), c.getModel(), c.getYear()))
          .collect(Collectors.toList()));
    } else {
      getCarsResponse.setAvailableCarsList(
          carsList.stream().map(c -> new ClientCar(c.getMake(), c.getModel(), c.getYear()))
              .collect(Collectors.toList()));
    }
    getCarsResponse.setAvailableWarranty("2 Years Warranty");

    // List<Agent> agentsList = agentService.getAgentList();


    return getCarsResponse;
  }

  @Override
  public ClientCar getCar(Long id) {
    Optional<Car> car =
        carsList.stream().filter(c -> c.getId().longValue() == id.longValue()).findFirst();
    if (car.isPresent()) {
      Car thisCar = car.get();
      return new ClientCar(thisCar.getMake(), thisCar.getModel(), thisCar.getYear());
    } else {
      return null;
    }
  }

  @Override
  public ClientCar addCar(Car car) {
    Car newCar = carRepository.save(car);
    return new ClientCar(newCar.getMake(), newCar.getModel(), newCar.getYear());
  }

  @Override
  public void updateCar(Car car, Long id) {
    int counter = 0;
    for (Car car1 : carsList) {
      if (car1.getId().longValue() == id.longValue()) {
        carsList.set(counter, car);
      }
      counter++;
    }
  }

  @Override
  public void deleteCar(Long id) {
    carRepository.delete(carRepository.findById(id).get());
  }

  @Override
  public ClientCar getCarDetailsById(Long id) {

    Optional<Car> car = carRepository.findById(id);

    if (car.isPresent()) {
      Car thisCar = car.get();
      return new ClientCar(thisCar.getMake(), thisCar.getModel(), thisCar.getYear());
    } else {
      throw new CarNotFoundException("Invalid Id", "Please use a different Id");
    }
  }
}

