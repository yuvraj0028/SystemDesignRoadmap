#pragma once

class Engine {
public:
    Engine(double volume, double mileage);

    void on();
    void off();
    bool isStarted() const;
    double getVolume() const;
    double getMileage() const;
    void go(double mileage);

private:
    double volume_;
    double mileage_;
    bool started_ = false;
};
