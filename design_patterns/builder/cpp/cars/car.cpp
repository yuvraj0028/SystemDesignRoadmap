#include "car.h"

#include <utility>

Car::Car(
    CarType carType,
    int seats,
    const Engine& engine,
    Transmission transmission,
    std::unique_ptr<TripComputer> tripComputer,
    std::unique_ptr<GPSNavigator> gpsNavigator)
    : carType_(carType),
      seats_(seats),
      engine_(engine),
      transmission_(transmission),
      tripComputer_(std::move(tripComputer)),
      gpsNavigator_(std::move(gpsNavigator)) {
    if (tripComputer_) {
        tripComputer_->setCar(this);
    }
}

CarType Car::getCarType() const {
    return carType_;
}

double Car::getFuel() const {
    return fuel_;
}

void Car::setFuel(double fuel) {
    fuel_ = fuel;
}

int Car::getSeats() const {
    return seats_;
}

const Engine& Car::getEngine() const {
    return engine_;
}

Transmission Car::getTransmission() const {
    return transmission_;
}

const TripComputer* Car::getTripComputer() const {
    return tripComputer_.get();
}

const GPSNavigator* Car::getGpsNavigator() const {
    return gpsNavigator_.get();
}
