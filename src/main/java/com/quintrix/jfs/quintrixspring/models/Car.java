package com.quintrix.jfs.quintrixspring.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

  @Id
  Long id;

  String make;

  String model;

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

