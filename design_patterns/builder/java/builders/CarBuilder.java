package SystemDesignRoadmap.design_patterns.builder.java.builders;

import SystemDesignRoadmap.design_patterns.builder.java.cars.Car;
import SystemDesignRoadmap.design_patterns.builder.java.cars.CarType;
import SystemDesignRoadmap.design_patterns.builder.java.components.Engine;
import SystemDesignRoadmap.design_patterns.builder.java.components.GPSNavigator;
import SystemDesignRoadmap.design_patterns.builder.java.components.Transmission;
import SystemDesignRoadmap.design_patterns.builder.java.components.TripComputer;

public class CarBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Car getResult() {
        return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
    
}
