package com.quintrix.jfs.quintrixspring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.quintrix.jfs.quintrixspring.models.Car;

@Service
public class CarService {
  private List<Car> carsList = new ArrayList<>(
      Arrays.asList(new Car(1L, "Ford", "SUV", 2011), new Car(2L, "Honda", "SUV", 2005),
          new Car(3L, "Honda", "Sedan", 2012), new Car(4L, "Volvo", "Truck", 2015)));

  public List<Car> getCarsList() {
    return carsList;
  }

  public Car getCar(Long id) {
    Optional<Car> car =
        carsList.stream().filter(c -> c.getId().longValue() == id.longValue()).findFirst();
    if (car.isPresent()) {
      return car.get();
    } else {
      return null;
    }
  }

  public Car addCar(Car car) {
    carsList.add(car);
    return car;
  }

  public void updateCar(Car car, Long id) {
    int counter = 0;
    for (Car car1 : carsList) {
      if (car1.getId().longValue() == id.longValue()) {
        carsList.set(counter, car);
      }
      counter++;
    }
  }

  public void deleteCar(Long id) {
    carsList.removeIf(car -> car.getId().longValue() == id.longValue());
  }
}
