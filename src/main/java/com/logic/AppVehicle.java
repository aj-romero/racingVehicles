package com.logic;

import com.vehicles.Vehicle;

public class AppVehicle implements IAppVehicle{

  @Override
  public String timeToTravel(Vehicle vehicle, int distance) {
    float speed = vehicle.getSPEED();
    float km = metersToKilometers(distance);
    StringBuilder result = new StringBuilder();
    if (distance != 0) {
      float hour = km / speed;
      float remain = km % speed;
      int intHour = (int) hour;
      result.append(" ").append(intHour).append(" Hr.");
      if (remain != 0 && intHour > 0) {
        int intRemain = (int) (remain * 10);
        result.append(" con ").append(intRemain).append(" Min.");
      } else {
        int intRemain = (int) (remain);
        if(remain > 60){
          result.delete(0, result.length());
          result.append(" ").append(1).append(" Hr.");
          result.append(" con ").append((intRemain - 60)).append(" Min.");
        }
        else{
          result.append(" con ").append(intRemain).append(" Min.");
        }

      }
    } else {
      result.append("Gring, Check the distance and try again, distance > 0");
    }
    return result.toString();
  }

  private float metersToKilometers(int distance) {
    return (float) distance / 1000;
  }
}
