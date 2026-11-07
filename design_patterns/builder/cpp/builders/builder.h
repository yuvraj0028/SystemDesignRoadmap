#pragma once

#include <memory>

#include "../cars/car_type.h"
#include "../components/engine.h"
#include "../components/gps_navigator.h"
#include "../components/transmission.h"
#include "../components/trip_computer.h"

class Builder {
public:
    virtual ~Builder() = default;

    virtual void setCarType(CarType type) = 0;
    virtual void setSeats(int seats) = 0;
    virtual void setEngine(const Engine& engine) = 0;
    virtual void setTransmission(Transmission transmission) = 0;
    virtual void setTripComputer(std::unique_ptr<TripComputer> tripComputer) = 0;
    virtual void setGPSNavigator(std::unique_ptr<GPSNavigator> gpsNavigator) = 0;
};
