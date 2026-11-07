from __future__ import annotations

from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from cars.car import Car


class TripComputer:
    def __init__(self) -> None:
        self.car: Car | None = None

    def set_car(self, car: Car) -> None:
        self.car = car

    def show_fuel_level(self) -> None:
        if self.car is not None:
            print(f"Fuel level: {self.car.get_fuel()}")

    def show_status(self) -> None:
        if self.car is not None:
            status = (
                "Car is started"
                if self.car.get_engine().is_started()
                else "Car isn't started"
            )
            print(status)
