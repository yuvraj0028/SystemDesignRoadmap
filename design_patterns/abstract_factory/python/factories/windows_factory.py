from ..buttons.button import Button
from ..buttons.windows_button import WindowsButton
from ..checkboxes.checkbox import Checkbox
from ..checkboxes.windows_checkbox import WindowsCheckbox
from .gui_factory import GUIFactory


class WindowsFactory(GUIFactory):
    def create_button(self) -> Button:
        return WindowsButton()

    def create_checkbox(self) -> Checkbox:
        return WindowsCheckbox()