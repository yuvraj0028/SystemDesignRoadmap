#include <iostream>

// Class for baking bread
class Baker {
public:
    void bakeBread() {
        std::cout << "Baking bread..." << std::endl;
    }
};

// Class for managing inventory
class InventoryManager {
public:
    void manageInventory() {
        std::cout << "Managing inventory..." << std::endl;
    }
};

// Class for ordering supplies
class SupplyOrder {
public:
    void orderSupplies() {
        std::cout << "Ordering supplies..." << std::endl;
    }
};

// Class for serving customers
class CustomerService {
public:
    void serveCustomer() {
        std::cout << "Serving customers..." << std::endl;
    }
};

// Class for cleaning the bakery
class BakeryCleaner {
public:
    void cleanBakery() {
        std::cout << "Cleaning the bakery..." << std::endl;
    }
};

int main() {
    Baker baker;
    InventoryManager inventoryManager;
    SupplyOrder supplyOrder;
    CustomerService customerService;
    BakeryCleaner bakeryCleaner;

    baker.bakeBread();
    inventoryManager.manageInventory();
    supplyOrder.orderSupplies();
    customerService.serveCustomer();
    bakeryCleaner.cleanBakery();

    return 0;
}