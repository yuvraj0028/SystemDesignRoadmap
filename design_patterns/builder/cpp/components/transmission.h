#pragma once

enum class Transmission {
    SINGLE_SPEED,
    MANUAL,
    AUTOMATIC,
    SEMI_AUTOMATIC
};

inline const char* toString(Transmission transmission) {
    switch (transmission) {
        case Transmission::SINGLE_SPEED:
            return "SINGLE_SPEED";
        case Transmission::MANUAL:
            return "MANUAL";
        case Transmission::AUTOMATIC:
            return "AUTOMATIC";
        case Transmission::SEMI_AUTOMATIC:
            return "SEMI_AUTOMATIC";
    }
    return "UNKNOWN";
}
