from .checkbox import Checkbox


class MacOSCheckbox(Checkbox):
    def paint(self) -> None:
        print("You have created MacOSCheckbox.")