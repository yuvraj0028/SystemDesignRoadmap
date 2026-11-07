#pragma once

#include <memory>

#include "../components/engine.h"
#include "../components/gps_navigator.h"
#include "../components/transmission.h"
#include "../components/trip_computer.h"
#include "car_type.h"

class Car {
public:
    Car(
        CarType carType,
        int seats,
        const Engine& engine,
        Transmission transmission,
        std::unique_ptr<TripComputer> tripComputer,
        std::unique_ptr<GPSNavigator> gpsNavigator);

    CarType getCarType() const;
    double getFuel() const;
    void setFuel(double fuel);
    int getSeats() const;
    const Engine& getEngine() const;
    Transmission getTransmission() const;
    const TripComputer* getTripComputer() const;
    const GPSNavigator* getGpsNavigator() const;

private:
    CarType carType_;
    int seats_;
    Engine engine_;
    Transmission transmission_;
    std::unique_ptr<TripComputer> tripComputer_;
    std::unique_ptr<GPSNavigator> gpsNavigator_;
    double fuel_ = 0;
};
