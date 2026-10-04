#pragma once

#include <memory>

#include "buttons/button.h"
#include "checkboxes/checkbox.h"
#include "factories/gui_factory.h"

class App {
public:
    explicit App(const GUIFactory& factory);

    void paint() const;

private:
    std::unique_ptr<Button> button_;
    std::unique_ptr<Checkbox> checkbox_;
};