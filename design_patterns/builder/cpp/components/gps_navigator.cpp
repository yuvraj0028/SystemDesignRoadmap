#include "gps_navigator.h"

#include <utility>

GPSNavigator::GPSNavigator()
    : route_(
          "221b, Baker Street, London to Scotland Yard, 8-10 Broadway, London") {}

GPSNavigator::GPSNavigator(std::string route)
    : route_(std::move(route)) {}

const std::string& GPSNavigator::getRoute() const {
    return route_;
}
