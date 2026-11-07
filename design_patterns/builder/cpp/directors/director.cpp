#include "director.h"

#include <memory>

#include "../cars/car_type.h"
#include "../components/engine.h"
#include "../components/gps_navigator.h"
#include "../components/transmission.h"
#include "../components/trip_computer.h"

void Director::constructSportsCar(Builder& builder) const {
    builder.setCarType(CarType::SPORTS_CAR);
    builder.setSeats(2);
    builder.setEngine(Engine(3.0, 0));
    builder.setTransmission(Transmission::SEMI_AUTOMATIC);
    builder.setTripComputer(std::make_unique<TripComputer>());
    builder.setGPSNavigator(std::make_unique<GPSNavigator>());
}

void Director::constructCityCar(Builder& builder) const {
    builder.setCarType(CarType::CITY_CAR);
    builder.setSeats(4);
    builder.setEngine(Engine(1.2, 0));
    builder.setTransmission(Transmission::AUTOMATIC);
    builder.setTripComputer(std::make_unique<TripComputer>());
    builder.setGPSNavigator(std::make_unique<GPSNavigator>());
}

void Director::constructSUV(Builder& builder) const {
    builder.setCarType(CarType::SUV);
    builder.setSeats(5);
    builder.setEngine(Engine(2.5, 0));
    builder.setTransmission(Transmission::MANUAL);
    builder.setTripComputer(std::make_unique<TripComputer>());
    builder.setGPSNavigator(std::make_unique<GPSNavigator>());
}
