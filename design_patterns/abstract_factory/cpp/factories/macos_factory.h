#pragma once

#include <memory>

#include "../buttons/macos_button.h"
#include "../checkboxes/macos_checkbox.h"
#include "gui_factory.h"

class MacOSFactory : public GUIFactory {
public:
    std::unique_ptr<Button> createButton() const override;
    std::unique_ptr<Checkbox> createCheckbox() const override;
};