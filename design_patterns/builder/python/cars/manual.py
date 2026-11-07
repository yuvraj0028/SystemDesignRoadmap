from __future__ import annotations

from cars.car_type import CarType
from components.engine import Engine
from components.gps_navigator import GPSNavigator
from components.transmission import Transmission
from components.trip_computer import TripComputer


class Manual:
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

    def print(self) -> str:
        lines = [
            f"Type of car: {self.car_type.name}",
            f"Count of seats: {self.seats}",
            f"Engine: volume - {self.engine.get_volume()}; "
            f"mileage - {self.engine.get_mileage()}",
            f"Transmission: {self.transmission.name}",
            f"Trip Computer: {'Functional' if self.trip_computer is not None else 'N/A'}",
            f"GPS Navigator: {'Functional' if self.gps_navigator is not None else 'N/A'}",
        ]
        return "\n".join(lines)
