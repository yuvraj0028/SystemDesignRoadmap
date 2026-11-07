#pragma once

#include <string>

class GPSNavigator {
public:
    GPSNavigator();
    explicit GPSNavigator(std::string route);

    const std::string& getRoute() const;

private:
    std::string route_;
};
