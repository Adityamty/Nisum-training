import java.util.LinkedHashMap;
import java.util.Map;

class RestaurantMenu {
    private LinkedHashMap<String, HashMap<String, Double>> menu = new LinkedHashMap<>();

    public void addItem(String category, String name, double price) {
        menu.putIfAbsent(category, new HashMap<>());
        menu.get(category).put(name, price);
    }

    public void removeItem(String category, String name) {
        if (menu.containsKey(category)) {
            menu.get(category).remove(name);
        }
    }

    public void displayMenu() {
        System.out.println("Restaurant Menu:");
        menu.forEach((category, items) -> {
            System.out.println(category + ":");
            items.forEach((name, price) -> System.out.println("  " + name + " - $" + price));
        });
    }
}

public class RestaurantMenuDemo {
    public static void main(String[] args) {
        RestaurantMenu menu = new RestaurantMenu();
        menu.addItem("Appetizer", "Spring Rolls", 5.99);
        menu.addItem("Main Course", "Steak", 18.99);
        menu.addItem("Dessert", "Ice Cream", 4.99);
        menu.displayMenu();
    }
}
