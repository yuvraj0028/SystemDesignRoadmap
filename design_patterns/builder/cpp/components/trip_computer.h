#pragma once

class Car;

class TripComputer {
public:
    void setCar(Car* car);
    void showFuelLevel() const;
    void showStatus() const;

private:
    Car* car_ = nullptr;
};
