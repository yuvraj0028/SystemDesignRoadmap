import java.util.*;

// Interface for vegetarian menu
interface IVegetarianMenu {
    List<String> getVegetarianItems();
}

// Interface for non-vegetarian menu
interface INonVegetarianMenu {
    List<String> getNonVegetarianItems();
}

// Interface for drinks menu
interface IDrinkMenu {
    List<String> getDrinkItems();
}

// Class for vegetarian menu
class VegetarianMenu implements IVegetarianMenu {
    public List<String> getVegetarianItems() {
        return Arrays.asList("Vegetable Curry", "Paneer Tikka", "Salad");
    }
}

// Class for non-vegetarian menu
class NonVegetarianMenu implements INonVegetarianMenu {
    public List<String> getNonVegetarianItems() {
        return Arrays.asList("Chicken Curry", "Fish Fry", "Mutton Biryani");
    }
}

// Class for drinks menu
class DrinkMenu implements IDrinkMenu {
    public List<String> getDrinkItems() {
        return Arrays.asList("Water", "Soda", "Juice");
    }
}

// Function to display menu items for a vegetarian customer
class MenuDisplay {
    public static void displayVegetarianMenu(IVegetarianMenu menu) {
        System.out.println("Vegetarian Menu:");
        for (String item : menu.getVegetarianItems()) {
            System.out.println("- " + item);
        }
    }

    // Function to display menu items for a non-vegetarian customer
    public static void displayNonVegetarianMenu(INonVegetarianMenu menu) {
        System.out.println("Non-Vegetarian Menu:");
        for (String item : menu.getNonVegetarianItems()) {
            System.out.println("- " + item);
        }
    }
}


public record InterfaceSeggregation() {
    public static void main(String[] args) {
        VegetarianMenu vegMenu = new VegetarianMenu();
        NonVegetarianMenu nonVegMenu = new NonVegetarianMenu();
        DrinkMenu drinkMenu = new DrinkMenu();

        MenuDisplay.displayVegetarianMenu(vegMenu);
        MenuDisplay.displayNonVegetarianMenu(nonVegMenu);
    }    
}
