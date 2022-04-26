package com.quintrix.jfs.quintrixspring.models;

public class ClientCar {

  String make;

  String model;

  Integer year;

  public ClientCar() {

  }

  public ClientCar(String make, String model, Integer year) {
    super();
    this.make = make;
    this.model = model;
    this.year = year;
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

