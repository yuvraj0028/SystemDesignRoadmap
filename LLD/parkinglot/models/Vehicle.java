package SystemDesignRoadmap.LLD.parkinglot.models;

import SystemDesignRoadmap.LLD.parkinglot.enums.VehicleType;

public abstract class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;

    protected Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return this.vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    @Override
    public String toString(){
        return vehicleType + "{" + "vehicleNumber='" + vehicleNumber + '\'' + '}';
    }
}
