#pragma once

#include <memory>

#include "../buttons/button.h"
#include "../checkboxes/checkbox.h"

class GUIFactory {
public:
    virtual ~GUIFactory() = default;
    virtual std::unique_ptr<Button> createButton() const = 0;
    virtual std::unique_ptr<Checkbox> createCheckbox() const = 0;
};