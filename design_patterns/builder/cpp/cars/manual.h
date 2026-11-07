#pragma once

#include <memory>
#include <string>

#include "../components/engine.h"
#include "../components/gps_navigator.h"
#include "../components/transmission.h"
#include "../components/trip_computer.h"
#include "car_type.h"

class Manual {
public:
    Manual(
        CarType carType,
        int seats,
        const Engine& engine,
        Transmission transmission,
        std::unique_ptr<TripComputer> tripComputer,
        std::unique_ptr<GPSNavigator> gpsNavigator);

    std::string print() const;

private:
    CarType carType_;
    int seats_;
    Engine engine_;
    Transmission transmission_;
    std::unique_ptr<TripComputer> tripComputer_;
    std::unique_ptr<GPSNavigator> gpsNavigator_;
};
