#include "app.h"

App::App(const GUIFactory& factory)
    : button_(factory.createButton()),
      checkbox_(factory.createCheckbox()) {}

void App::paint() const {
    button_->paint();
    checkbox_->paint();
}