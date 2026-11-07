#include "car_builder.h"

#include <utility>

void CarBuilder::setCarType(CarType type) {
    type_ = type;
}

void CarBuilder::setSeats(int seats) {
    seats_ = seats;
}

void CarBuilder::setEngine(const Engine& engine) {
    engine_ = engine;
}

void CarBuilder::setTransmission(Transmission transmission) {
    transmission_ = transmission;
}

void CarBuilder::setTripComputer(std::unique_ptr<TripComputer> tripComputer) {
    tripComputer_ = std::move(tripComputer);
}

void CarBuilder::setGPSNavigator(std::unique_ptr<GPSNavigator> gpsNavigator) {
    gpsNavigator_ = std::move(gpsNavigator);
}

Car CarBuilder::getResult() {
    return Car(
        type_,
        seats_,
        engine_,
        transmission_,
        std::move(tripComputer_),
        std::move(gpsNavigator_));
}
