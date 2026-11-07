package SystemDesignRoadmap.lld.parking_lot.models;

import SystemDesignRoadmap.lld.parking_lot.enums.VehicleType;

public class Car extends Vehicle {
    public Car(String vehicleNumber) {
        super(vehicleNumber, VehicleType.CAR);
    }
}
