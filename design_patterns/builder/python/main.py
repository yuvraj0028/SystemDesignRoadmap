from builders.car_builder import CarBuilder
from builders.car_manual_builder import CarManualBuilder
from directors.director import Director


def main() -> None:
    director = Director()

    builder = CarBuilder()
    director.construct_sports_car(builder)
    car = builder.get_result()
    print(f"Car built:\n{car.get_car_type().name}")

    print()

    manual_builder = CarManualBuilder()
    director.construct_sports_car(manual_builder)
    manual = manual_builder.get_result()
    print(f"Car manual built:\n{manual.print()}")


if __name__ == "__main__":
    main()
