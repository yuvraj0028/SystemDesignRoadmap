package SystemDesignRoadmap.LLD.parkinglot.models;

import SystemDesignRoadmap.LLD.parkinglot.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String vehicleNumber) {
        super(vehicleNumber, VehicleType.CAR);
    }
}
