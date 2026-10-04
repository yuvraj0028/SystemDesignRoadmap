from abc import ABC, abstractmethod
from typing import List


# Interface for vegetarian menu
class IVegetarianMenu(ABC):
    @abstractmethod
    def get_vegetarian_items(self) -> List[str]:
        ...


# Interface for non-vegetarian menu
class INonVegetarianMenu(ABC):
    @abstractmethod
    def get_non_vegetarian_items(self) -> List[str]:
        ...


# Interface for drinks menu
class IDrinkMenu(ABC):
    @abstractmethod
    def get_drink_items(self) -> List[str]:
        ...


# Class for vegetarian menu
class VegetarianMenu(IVegetarianMenu):
    def get_vegetarian_items(self) -> List[str]:
        return ["Vegetable Curry", "Paneer Tikka", "Salad"]


# Class for non-vegetarian menu
class NonVegetarianMenu(INonVegetarianMenu):
    def get_non_vegetarian_items(self) -> List[str]:
        return ["Chicken Curry", "Fish Fry", "Mutton Biryani"]


# Class for drinks menu
class DrinkMenu(IDrinkMenu):
    def get_drink_items(self) -> List[str]:
        return ["Water", "Soda", "Juice"]


class MenuDisplay:
    @staticmethod
    def display_vegetarian_menu(menu: IVegetarianMenu) -> None:
        print("Vegetarian Menu:")
        for item in menu.get_vegetarian_items():
            print("-", item)

    @staticmethod
    def display_non_vegetarian_menu(menu: INonVegetarianMenu) -> None:
        print("Non-Vegetarian Menu:")
        for item in menu.get_non_vegetarian_items():
            print("-", item)


def main() -> None:
    veg_menu = VegetarianMenu()
    non_veg_menu = NonVegetarianMenu()
    drink_menu = DrinkMenu()

    MenuDisplay.display_vegetarian_menu(veg_menu)
    MenuDisplay.display_non_vegetarian_menu(non_veg_menu)

    print("Drink Menu:")
    for item in drink_menu.get_drink_items():
        print("-", item)


if __name__ == "__main__":
    main()