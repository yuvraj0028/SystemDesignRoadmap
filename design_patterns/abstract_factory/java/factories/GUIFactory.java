package SystemDesignRoadmap.design_patterns.abstract_factory.java.factories;

import SystemDesignRoadmap.design_patterns.abstract_factory.java.buttons.Button;
import SystemDesignRoadmap.design_patterns.abstract_factory.java.checkboxes.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
