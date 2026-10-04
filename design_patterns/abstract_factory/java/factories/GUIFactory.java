package design_patterns.abstract_factory.java.factories;

import design_patterns.abstract_factory.java.buttons.Button;
import design_patterns.abstract_factory.java.checkboxes.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
