package SystemDesignRoadmap.design_patterns.abstract_factory.java;

import SystemDesignRoadmap.design_patterns.abstract_factory.java.factories.GUIFactory;
import SystemDesignRoadmap.design_patterns.abstract_factory.java.factories.MacOSFactory;
import SystemDesignRoadmap.design_patterns.abstract_factory.java.factories.WindowsFactory;

public class Main {
    public static void main(String[] args) {
        App app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        app = new App(factory);
        app.paint();
    }
}
