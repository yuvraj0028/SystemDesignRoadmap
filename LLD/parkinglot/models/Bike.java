package SystemDesignRoadmap.LLD.parkinglot.models;

import SystemDesignRoadmap.LLD.parkinglot.enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String vehicleNumber) {
        super(vehicleNumber, VehicleType.BIKE);
    }
}
