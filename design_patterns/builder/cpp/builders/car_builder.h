#pragma once

#include <memory>

#include "../cars/car.h"
#include "builder.h"

class CarBuilder : public Builder {
public:
    void setCarType(CarType type) override;
    void setSeats(int seats) override;
    void setEngine(const Engine& engine) override;
    void setTransmission(Transmission transmission) override;
    void setTripComputer(std::unique_ptr<TripComputer> tripComputer) override;
    void setGPSNavigator(std::unique_ptr<GPSNavigator> gpsNavigator) override;

    Car getResult();

private:
    CarType type_ = CarType::CITY_CAR;
    int seats_ = 0;
    Engine engine_{0, 0};
    Transmission transmission_ = Transmission::MANUAL;
    std::unique_ptr<TripComputer> tripComputer_;
    std::unique_ptr<GPSNavigator> gpsNavigator_;
};
