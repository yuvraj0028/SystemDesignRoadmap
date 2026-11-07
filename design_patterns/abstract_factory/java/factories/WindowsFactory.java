package SystemDesignRoadmap.design_patterns.abstract_factory.java.factories;

import SystemDesignRoadmap.design_patterns.abstract_factory.java.buttons.Button;
import SystemDesignRoadmap.design_patterns.abstract_factory.java.buttons.WindowsButton;
import SystemDesignRoadmap.design_patterns.abstract_factory.java.checkboxes.Checkbox;
import SystemDesignRoadmap.design_patterns.abstract_factory.java.checkboxes.WindowsCheckbox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
