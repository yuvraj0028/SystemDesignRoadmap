from abc import ABC, abstractmethod

from ..buttons.button import Button
from ..checkboxes.checkbox import Checkbox


class GUIFactory(ABC):
    @abstractmethod
    def create_button(self) -> Button:
        ...

    @abstractmethod
    def create_checkbox(self) -> Checkbox:
        ...