# Base class for shapes
class Rectangle:
    def __init__(self, w: float, h: float) -> None:
        self.width = w
        self.height = h

    def area(self) -> float:
        return self.width * self.height

    def get_width(self) -> float:
        return self.width

    def get_height(self) -> float:
        return self.height

    def set_width(self, w: float) -> None:
        self.width = w

    def set_height(self, h: float) -> None:
        self.height = h


# Derived class for squares.
# This VIOLATES Liskov Substitution: a square is forced to keep width == height,
# so calling set_width changes height too and the base class contract is broken.
class Square(Rectangle):
    def __init__(self, size: float) -> None:
        super().__init__(size, size)

    def set_width(self, w: float) -> None:
        self.width = self.height = w

    def set_height(self, h: float) -> None:
        self.width = self.height = h


def main() -> None:
    s = Square(5)
    s.set_width(10)
    print("Area:", s.area())

    shape: Rectangle = s
    shape.set_height(3)
    print("Area after set_height(3):", shape.area())


if __name__ == "__main__":
    main()