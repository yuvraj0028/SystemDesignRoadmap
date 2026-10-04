from .buttons.button import Button
from .checkboxes.checkbox import Checkbox
from .factories.gui_factory import GUIFactory


class App:
    def __init__(self, factory: GUIFactory) -> None:
        self.button: Button = factory.create_button()
        self.checkbox: Checkbox = factory.create_checkbox()

    def paint(self) -> None:
        self.button.paint()
        self.checkbox.paint()