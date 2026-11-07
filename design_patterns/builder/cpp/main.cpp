#include <iostream>

#include "builders/car_builder.h"
#include "builders/car_manual_builder.h"
#include "cars/car.h"
#include "cars/manual.h"
#include "directors/director.h"

int main() {
    Director director;

    CarBuilder builder;
    director.constructSportsCar(builder);
    Car car = builder.getResult();
    std::cout << "Car built:\n" << toString(car.getCarType()) << std::endl;

    std::cout << std::endl;

    CarManualBuilder manualBuilder;
    director.constructSportsCar(manualBuilder);
    Manual manual = manualBuilder.getResult();
    std::cout << "Car manual built:\n" << manual.print() << std::endl;

    return 0;
}
