package com.app;

import com.logic.*;
import com.vehicles.Bike;
import com.vehicles.Car;
import com.vehicles.Motorcycle;
import com.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static Bike bike = new Bike();
  private static Car car = new Car();
  private static Motorcycle motorcycle = new Motorcycle();
  private static List<Vehicle> vehicles = new ArrayList<>(List.of(bike, car, motorcycle));
  private static Scanner es = new Scanner(System.in);
  private static IAppVehicle appVehicle = new AppVehicle();

  public static void main(String[] args) {
    printf("Welcome to this application");
    printf("%nI will help you to know the time to travel the distance that you give to me in meters");
    printInstructions();
    actions();
  }

  private static void actions() {
    int action = checkInput();
    if (action >= 0 && action <= vehicles.size()) {
      switch (action) {
        case 0 -> {
          printf("%n See you later!");
          System.exit(0);
        }
        case 1 -> getTimeFor(vehicles.get(action - 1));
        case 2 -> getTimeFor(vehicles.get(action - 1));
        case 3 -> getTimeFor(vehicles.get(action - 1));
        default -> {
          printInstructions();
          actions();
        }
      }
    } else {
      printInstructions();
      printf("%nPlease, type again your choice [0 - " + vehicles.size() + "]: ");
      actions();
    }
  }

  private static void printInstructions() {
    printf("%nPress: ");
    printf("%n0 - To quit the application");
    for (int i = 0; i < vehicles.size(); i++) {
      printf(
          String.format(
              "%n%d - To get time for: %s", (i + 1), vehicles.get(i).getClass().getSimpleName()));
    }
    printf("%nEnter your choice[]: ");
  }

  private static void printf(String s) {
    System.out.printf(s);
  }

  private static void getTimeFor(Vehicle v) {
    printf("%nPlease, type the distance to travel in meters[]: ");
    int distance = checkInput();
    String time = appVehicle.timeToTravel(v, distance);
    printf("%nInput:");
    printf("%nVehicle: " + v.getClass().getSimpleName());
    printf("%nDistance: " + distance + " meters");
    printf("%nOutput:");
    printf("%n" + time);
    printInstructions();
    actions();
  }

  private static int checkInput() {
    int acc = 0;
    boolean b = true;
    while (b) {
      try {
        acc = Integer.parseInt(es.nextLine());
        b = false;
      } catch (Exception e) {
        b = true;
        printf("Please, type an integer number ");
      }
    }
    return acc;
  }
}
