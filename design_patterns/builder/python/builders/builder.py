from abc import ABC, abstractmethod

from cars.car_type import CarType
from components.engine import Engine
from components.gps_navigator import GPSNavigator
from components.transmission import Transmission
from components.trip_computer import TripComputer


class Builder(ABC):
    @abstractmethod
    def set_car_type(self, car_type: CarType) -> None:
        ...

    @abstractmethod
    def set_seats(self, seats: int) -> None:
        ...

    @abstractmethod
    def set_engine(self, engine: Engine) -> None:
        ...

    @abstractmethod
    def set_transmission(self, transmission: Transmission) -> None:
        ...

    @abstractmethod
    def set_trip_computer(self, trip_computer: TripComputer) -> None:
        ...

    @abstractmethod
    def set_gps_navigator(self, gps_navigator: GPSNavigator) -> None:
        ...
