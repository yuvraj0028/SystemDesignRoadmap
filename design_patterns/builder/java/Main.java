package SystemDesignRoadmap.design_patterns.builder.java;

import SystemDesignRoadmap.design_patterns.builder.java.builders.CarBuilder;
import SystemDesignRoadmap.design_patterns.builder.java.builders.CarManualBuilder;
import SystemDesignRoadmap.design_patterns.builder.java.cars.Car;
import SystemDesignRoadmap.design_patterns.builder.java.cars.Manual;
import SystemDesignRoadmap.design_patterns.builder.java.directors.Director;

public class Main {
    public static void main(String[] args) {
        // The client code can create a builder object, pass it to the director and then get the product from the builder.
        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());

        System.out.println();

        CarManualBuilder manualBuilder = new CarManualBuilder();
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("Car manual built:\n" + carManual.print());
    }
}
