#include "manual.h"

#include <sstream>
#include <utility>

Manual::Manual(
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
      gpsNavigator_(std::move(gpsNavigator)) {}

std::string Manual::print() const {
    std::ostringstream info;
    info << "Type of car: " << toString(carType_) << "\n";
    info << "Count of seats: " << seats_ << "\n";
    info << "Engine: volume - " << engine_.getVolume() << "; mileage - "
         << engine_.getMileage() << "\n";
    info << "Transmission: " << toString(transmission_) << "\n";
    info << "Trip Computer: " << (tripComputer_ ? "Functional" : "N/A") << "\n";
    info << "GPS Navigator: " << (gpsNavigator_ ? "Functional" : "N/A") << "\n";
    return info.str();
}
