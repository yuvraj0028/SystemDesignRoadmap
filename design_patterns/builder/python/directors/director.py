from builders.builder import Builder
from cars.car_type import CarType
from components.engine import Engine
from components.gps_navigator import GPSNavigator
from components.transmission import Transmission
from components.trip_computer import TripComputer


class Director:
    def construct_sports_car(self, builder: Builder) -> None:
        builder.set_car_type(CarType.SPORTS_CAR)
        builder.set_seats(2)
        builder.set_engine(Engine(3.0, 0))
        builder.set_transmission(Transmission.SEMI_AUTOMATIC)
        builder.set_trip_computer(TripComputer())
        builder.set_gps_navigator(GPSNavigator())

    def construct_city_car(self, builder: Builder) -> None:
        builder.set_car_type(CarType.CITY_CAR)
        builder.set_seats(4)
        builder.set_engine(Engine(1.2, 0))
        builder.set_transmission(Transmission.AUTOMATIC)
        builder.set_trip_computer(TripComputer())
        builder.set_gps_navigator(GPSNavigator())

    def construct_suv(self, builder: Builder) -> None:
        builder.set_car_type(CarType.SUV)
        builder.set_seats(5)
        builder.set_engine(Engine(2.5, 0))
        builder.set_transmission(Transmission.MANUAL)
        builder.set_trip_computer(TripComputer())
        builder.set_gps_navigator(GPSNavigator())
