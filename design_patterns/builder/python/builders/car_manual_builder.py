from __future__ import annotations

from builders.builder import Builder
from cars.car_type import CarType
from cars.manual import Manual
from components.engine import Engine
from components.gps_navigator import GPSNavigator
from components.transmission import Transmission
from components.trip_computer import TripComputer


class CarManualBuilder(Builder):
    def __init__(self) -> None:
        self.car_type: CarType | None = None
        self.seats = 0
        self.engine: Engine | None = None
        self.transmission: Transmission | None = None
        self.trip_computer: TripComputer | None = None
        self.gps_navigator: GPSNavigator | None = None

    def set_car_type(self, car_type: CarType) -> None:
        self.car_type = car_type

    def set_seats(self, seats: int) -> None:
        self.seats = seats

    def set_engine(self, engine: Engine) -> None:
        self.engine = engine

    def set_transmission(self, transmission: Transmission) -> None:
        self.transmission = transmission

    def set_trip_computer(self, trip_computer: TripComputer) -> None:
        self.trip_computer = trip_computer

    def set_gps_navigator(self, gps_navigator: GPSNavigator) -> None:
        self.gps_navigator = gps_navigator

    def get_result(self) -> Manual:
        if (
            self.car_type is None
            or self.engine is None
            or self.transmission is None
        ):
            raise ValueError("Car manual is not fully constructed")
        return Manual(
            self.car_type,
            self.seats,
            self.engine,
            self.transmission,
            self.trip_computer,
            self.gps_navigator,
        )
