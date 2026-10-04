# Class for baking bread
class Baker:
    def bake_bread(self) -> None:
        print("Baking bread...")


# Class for managing inventory
class InventoryManager:
    def manage_inventory(self) -> None:
        print("Managing inventory...")


# Class for ordering supplies
class SupplyOrder:
    def order_supplies(self) -> None:
        print("Ordering supplies...")


# Class for serving customers
class CustomerService:
    def serve_customer(self) -> None:
        print("Serving customers...")


# Class for cleaning the bakery
class BakeryCleaner:
    def clean_bakery(self) -> None:
        print("Cleaning the bakery...")


def main() -> None:
    baker = Baker()
    inventory_manager = InventoryManager()
    supply_order = SupplyOrder()
    customer_service = CustomerService()
    bakery_cleaner = BakeryCleaner()

    baker.bake_bread()
    inventory_manager.manage_inventory()
    supply_order.order_supplies()
    customer_service.serve_customer()
    bakery_cleaner.clean_bakery()


if __name__ == "__main__":
    main()