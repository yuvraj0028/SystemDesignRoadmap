package design_patterns.abstract_factory.java.factories;

import design_patterns.abstract_factory.java.buttons.Button;
import design_patterns.abstract_factory.java.checkboxes.Checkbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new design_patterns.abstract_factory.java.buttons.WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new design_patterns.abstract_factory.java.checkboxes.WindowsCheckbox();
    }
    
}
