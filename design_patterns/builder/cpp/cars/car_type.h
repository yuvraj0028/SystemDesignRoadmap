#pragma once

enum class CarType {
    CITY_CAR,
    SPORTS_CAR,
    SUV
};

inline const char* toString(CarType type) {
    switch (type) {
        case CarType::CITY_CAR:
            return "CITY_CAR";
        case CarType::SPORTS_CAR:
            return "SPORTS_CAR";
        case CarType::SUV:
            return "SUV";
    }
    return "UNKNOWN";
}
