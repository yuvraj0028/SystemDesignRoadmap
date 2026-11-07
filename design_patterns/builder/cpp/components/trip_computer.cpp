#include "trip_computer.h"

#include <iostream>

#include "../cars/car.h"

void TripComputer::setCar(Car* car) {
    car_ = car;
}

void TripComputer::showFuelLevel() const {
    if (car_ != nullptr) {
        std::cout << "Fuel level: " << car_->getFuel() << std::endl;
    }
}

void TripComputer::showStatus() const {
    if (car_ != nullptr) {
        std::cout << (car_->getEngine().isStarted() ? "Car is started"
                                                    : "Car isn't started")
                  << std::endl;
    }
}
