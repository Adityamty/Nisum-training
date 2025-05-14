import java.util.ArrayList;

class Item {
    String name;
    double price;
    int quantity;

    Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " | Price: " + price + " | Quantity: " + quantity;
    }
}

class ShoppingCart {
    private ArrayList<Item> cart = new ArrayList<>();

    public void addItem(String name, double price, int quantity) {
        cart.add(new Item(name, price, quantity));
    }

    public void removeItem(String name) {
        cart.removeIf(item -> item.name.equalsIgnoreCase(name));
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            cart.forEach(System.out::println);
        }
    }

    public double calculateTotal() {
        return cart.stream().mapToDouble(item -> item.price * item.quantity).sum();
    }
}

public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 1200.99, 1);
        cart.addItem("Headphones", 199.99, 2);
        cart.viewCart();
        System.out.println("Total Price: $" + cart.calculateTotal());
        cart.removeItem("Laptop");
        cart.viewCart();
    }
}
