#include <memory>

#include "app.h"
#include "factories/macos_factory.h"
#include "factories/windows_factory.h"

int main() {
    std::unique_ptr<GUIFactory> factory;

#ifdef __APPLE__
    factory = std::make_unique<MacOSFactory>();
#else
    factory = std::make_unique<WindowsFactory>();
#endif

    App app(*factory);
    app.paint();

    return 0;
}