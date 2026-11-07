#include "car_manual_builder.h"

#include <utility>

void CarManualBuilder::setCarType(CarType type) {
    type_ = type;
}

void CarManualBuilder::setSeats(int seats) {
    seats_ = seats;
}

void CarManualBuilder::setEngine(const Engine& engine) {
    engine_ = engine;
}

void CarManualBuilder::setTransmission(Transmission transmission) {
    transmission_ = transmission;
}

void CarManualBuilder::setTripComputer(
    std::unique_ptr<TripComputer> tripComputer) {
    tripComputer_ = std::move(tripComputer);
}

void CarManualBuilder::setGPSNavigator(
    std::unique_ptr<GPSNavigator> gpsNavigator) {
    gpsNavigator_ = std::move(gpsNavigator);
}

Manual CarManualBuilder::getResult() {
    return Manual(
        type_,
        seats_,
        engine_,
        transmission_,
        std::move(tripComputer_),
        std::move(gpsNavigator_));
}
