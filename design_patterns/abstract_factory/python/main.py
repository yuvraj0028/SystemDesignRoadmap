import platform

from .app import App
from .factories.gui_factory import GUIFactory
from .factories.macos_factory import MacOSFactory
from .factories.windows_factory import WindowsFactory


def main() -> None:
    factory: GUIFactory
    os_name = platform.system().lower()
    if "mac" in os_name or "darwin" in os_name:
        factory = MacOSFactory()
    else:
        factory = WindowsFactory()

    app = App(factory)
    app.paint()


if __name__ == "__main__":
    main()