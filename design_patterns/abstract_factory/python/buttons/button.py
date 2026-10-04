from abc import ABC, abstractmethod


class Button(ABC):
    @abstractmethod
    def paint(self) -> None:
        ...