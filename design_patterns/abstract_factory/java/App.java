package SystemDesignRoadmap.design_patterns.abstract_factory.java;

import SystemDesignRoadmap.design_patterns.abstract_factory.java.buttons.Button;
import SystemDesignRoadmap.design_patterns.abstract_factory.java.checkboxes.Checkbox;
import SystemDesignRoadmap.design_patterns.abstract_factory.java.factories.GUIFactory;

public class App {
    private Button button;
    private Checkbox checkbox;

    public App(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
    
}
