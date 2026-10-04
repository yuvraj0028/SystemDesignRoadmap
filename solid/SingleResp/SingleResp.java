// class for baking bread
class Baker {
    public void bakeBread() {
        System.out.println("Baking bread...");
    }
}

// Class for managing inventory
class InventoryManager {
    public void manageInventory() {
        System.out.println("Managing inventory...");
    }
}

// Class for ordering supplies
class SupplyOrder {
    public void orderSupplies() {
        System.out.println("Ordering supplies...");
    }
}

// Class for serving customers
class CustomerService {
    public void serveCustomer() {
        System.out.println("Serving customers...");
    }
}

// Class for cleaning the bakery
class BakeryCleaner {
    public void cleanBakery() {
        System.out.println("Cleaning the bakery...");
    }
}

class SingleResp {
    public static void main() {
        Baker baker = new Baker();
        InventoryManager inventoryManager = new InventoryManager();
        SupplyOrder supplyOrder = new SupplyOrder();
        CustomerService customerService = new CustomerService();
        BakeryCleaner bakeryCleaner = new BakeryCleaner();

        baker.bakeBread();
        inventoryManager.manageInventory();
        supplyOrder.orderSupplies();
        customerService.serveCustomer();
        bakeryCleaner.cleanBakery();   
    }
}