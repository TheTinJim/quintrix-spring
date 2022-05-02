package com.quintrix.jfs.quintrixspring.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Car {

  @Id
  Long id;

  @NotNull(message = "Make cannot be null")
  String make;

  @NotNull(message = "Model cannot be null")
  String model;

  @Min(value = 1908, message = "You cannot have a year before 1908")
  @Max(value = 2023, message = "You cannot have a year after 2023")
  Integer year;

  public Car() {

  }

  public Car(Long id, String make, String model, Integer year) {
    super();
    this.id = id;
    this.make = make;
    this.model = model;
    this.year = year;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }


}

