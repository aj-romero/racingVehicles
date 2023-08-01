package com.vehicles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {

  private float SPEED;

  protected Vehicle(float speed) {
    this.SPEED = speed;
  }
}
