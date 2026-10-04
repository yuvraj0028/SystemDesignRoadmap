from ..buttons.button import Button
from ..buttons.macos_button import MacOSButton
from ..checkboxes.checkbox import Checkbox
from ..checkboxes.macos_checkbox import MacOSCheckbox
from .gui_factory import GUIFactory


class MacOSFactory(GUIFactory):
    def create_button(self) -> Button:
        return MacOSButton()

    def create_checkbox(self) -> Checkbox:
        return MacOSCheckbox()