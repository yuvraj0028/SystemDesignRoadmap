#include "macos_factory.h"

std::unique_ptr<Button> MacOSFactory::createButton() const {
    return std::make_unique<MacOSButton>();
}

std::unique_ptr<Checkbox> MacOSFactory::createCheckbox() const {
    return std::make_unique<MacOSCheckbox>();
}