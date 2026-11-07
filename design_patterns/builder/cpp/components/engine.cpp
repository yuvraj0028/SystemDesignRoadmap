#include "engine.h"

#include <iostream>

Engine::Engine(double volume, double mileage)
    : volume_(volume), mileage_(mileage) {}

void Engine::on() {
    started_ = true;
}

void Engine::off() {
    started_ = false;
}

bool Engine::isStarted() const {
    return started_;
}

double Engine::getVolume() const {
    return volume_;
}

double Engine::getMileage() const {
    return mileage_;
}

void Engine::go(double mileage) {
    if (started_) {
        mileage_ += mileage;
    } else {
        std::cout << "Cannot go(), you must start engine first!" << std::endl;
    }
}
