import java.util.HashMap;

class Inventory {
    private HashMap<String, Integer> products = new HashMap<>();

    public void addProduct(String name, int quantity) {
        products.put(name, products.getOrDefault(name, 0) + quantity);
        System.out.println("Product updated: " + name);
    }

    public void removeProduct(String name) {
        if (products.remove(name) != null) {
            System.out.println("Product removed: " + name);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void checkStock(String name) {
        System.out.println(products.containsKey(name) ? name + " is in stock: " + products.get(name) : name + " not available.");
    }

    public void displayInventory() {
        System.out.println("Current Inventory:");
        products.forEach((key, value) -> System.out.println(key + " - Quantity: " + value));
    }
}

public class ProductInventoryDemo {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addProduct("Laptop", 10);
        inventory.addProduct("Mouse", 25);
        inventory.checkStock("Laptop");
        inventory.displayInventory();
        inventory.removeProduct("Mouse");
        inventory.displayInventory();
    }
}
