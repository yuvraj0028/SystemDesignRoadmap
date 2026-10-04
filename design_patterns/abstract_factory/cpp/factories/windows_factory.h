#pragma once

#include <memory>

#include "../buttons/windows_button.h"
#include "../checkboxes/windows_checkbox.h"
#include "gui_factory.h"

class WindowsFactory : public GUIFactory {
public:
    std::unique_ptr<Button> createButton() const override;
    std::unique_ptr<Checkbox> createCheckbox() const override;
};