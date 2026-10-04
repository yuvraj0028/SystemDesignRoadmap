package design_patterns.abstract_factory.java;

import design_patterns.abstract_factory.java.factories.GUIFactory;
import design_patterns.abstract_factory.java.factories.MacOSFactory;
import design_patterns.abstract_factory.java.factories.WindowsFactory;

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
