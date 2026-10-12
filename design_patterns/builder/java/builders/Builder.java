package SystemDesignRoadmap.design_patterns.builder.java.builders;

import SystemDesignRoadmap.design_patterns.builder.java.cars.CarType;
import SystemDesignRoadmap.design_patterns.builder.java.components.Engine;
import SystemDesignRoadmap.design_patterns.builder.java.components.GPSNavigator;
import SystemDesignRoadmap.design_patterns.builder.java.components.Transmission;
import SystemDesignRoadmap.design_patterns.builder.java.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
} 