#include "windows_factory.h"

std::unique_ptr<Button> WindowsFactory::createButton() const {
    return std::make_unique<WindowsButton>();
}

std::unique_ptr<Checkbox> WindowsFactory::createCheckbox() const {
    return std::make_unique<WindowsCheckbox>();
}