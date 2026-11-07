package SystemDesignRoadmap.design_patterns.abstract_factory.java.factories;

import SystemDesignRoadmap.design_patterns.abstract_factory.java.buttons.Button;
import SystemDesignRoadmap.design_patterns.abstract_factory.java.buttons.MacOSButton;
import SystemDesignRoadmap.design_patterns.abstract_factory.java.checkboxes.Checkbox;
import SystemDesignRoadmap.design_patterns.abstract_factory.java.checkboxes.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
