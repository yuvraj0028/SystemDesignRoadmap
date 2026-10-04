from .button import Button


class MacOSButton(Button):
    def paint(self) -> None:
        print("You have created MacOSButton.")