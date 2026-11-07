package SystemDesignRoadmap.lld.parking_lot.models;

import SystemDesignRoadmap.lld.parking_lot.enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String vehicleNumber) {
        super(vehicleNumber, VehicleType.BIKE);
    }
}
