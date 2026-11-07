from __future__ import annotations

from cars.car_type import CarType
from components.engine import Engine
from components.gps_navigator import GPSNavigator
from components.transmission import Transmission
from components.trip_computer import TripComputer


class Car:
    def __init__(
        self,
        car_type: CarType,
        seats: int,
        engine: Engine,
        transmission: Transmission,
        trip_computer: TripComputer | None,
        gps_navigator: GPSNavigator | None,
    ) -> None:
        self.car_type = car_type
        self.seats = seats
        self.engine = engine
        self.transmission = transmission
        self.trip_computer = trip_computer
        self.gps_navigator = gps_navigator
        self.fuel = 0.0

        if self.trip_computer is not None:
            self.trip_computer.set_car(self)

    def get_car_type(self) -> CarType:
        return self.car_type

    def get_fuel(self) -> float:
        return self.fuel

    def set_fuel(self, fuel: float) -> None:
        self.fuel = fuel

    def get_seats(self) -> int:
        return self.seats

    def get_engine(self) -> Engine:
        return self.engine

    def get_transmission(self) -> Transmission:
        return self.transmission

    def get_trip_computer(self) -> TripComputer | None:
        return self.trip_computer

    def get_gps_navigator(self) -> GPSNavigator | None:
        return self.gps_navigator
