#include <iostream>
#include <string>
#include <vector>

// Interface for vegetarian menu
class IVegetarianMenu {
public:
    virtual ~IVegetarianMenu() = default;
    virtual std::vector<std::string> getVegetarianItems() const = 0;
};

// Interface for non-vegetarian menu
class INonVegetarianMenu {
public:
    virtual ~INonVegetarianMenu() = default;
    virtual std::vector<std::string> getNonVegetarianItems() const = 0;
};

// Interface for drinks menu
class IDrinkMenu {
public:
    virtual ~IDrinkMenu() = default;
    virtual std::vector<std::string> getDrinkItems() const = 0;
};

// Class for vegetarian menu
class VegetarianMenu : public IVegetarianMenu {
public:
    std::vector<std::string> getVegetarianItems() const override {
        return {"Vegetable Curry", "Paneer Tikka", "Salad"};
    }
};

// Class for non-vegetarian menu
class NonVegetarianMenu : public INonVegetarianMenu {
public:
    std::vector<std::string> getNonVegetarianItems() const override {
        return {"Chicken Curry", "Fish Fry", "Mutton Biryani"};
    }
};

// Class for drinks menu
class DrinkMenu : public IDrinkMenu {
public:
    std::vector<std::string> getDrinkItems() const override {
        return {"Water", "Soda", "Juice"};
    }
};

// Helper to display menu items for a vegetarian customer
class MenuDisplay {
public:
    static void displayVegetarianMenu(const IVegetarianMenu& menu) {
        std::cout << "Vegetarian Menu:" << std::endl;
        for (const std::string& item : menu.getVegetarianItems()) {
            std::cout << "- " << item << std::endl;
        }
    }

    // Helper to display menu items for a non-vegetarian customer
    static void displayNonVegetarianMenu(const INonVegetarianMenu& menu) {
        std::cout << "Non-Vegetarian Menu:" << std::endl;
        for (const std::string& item : menu.getNonVegetarianItems()) {
            std::cout << "- " << item << std::endl;
        }
    }
};

int main() {
    VegetarianMenu vegMenu;
    NonVegetarianMenu nonVegMenu;
    DrinkMenu drinkMenu;

    MenuDisplay::displayVegetarianMenu(vegMenu);
    MenuDisplay::displayNonVegetarianMenu(nonVegMenu);

    std::cout << "Drink Menu:" << std::endl;
    for (const std::string& item : drinkMenu.getDrinkItems()) {
        std::cout << "- " << item << std::endl;
    }

    return 0;
}