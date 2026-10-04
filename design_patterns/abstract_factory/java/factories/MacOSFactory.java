package design_patterns.abstract_factory.java.factories;

import design_patterns.abstract_factory.java.buttons.Button;
import design_patterns.abstract_factory.java.checkboxes.Checkbox;

public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new design_patterns.abstract_factory.java.buttons.MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new design_patterns.abstract_factory.java.checkboxes.MacOSCheckbox();
    }
}
