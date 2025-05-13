import java.util.*;

public class CartApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Cart> cartList = new ArrayList<>();

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Item " + (i + 1) + ":");
            System.out.print("Item Name: ");
            String name = sc.nextLine();

            System.out.print("Item ID: ");
            String id = sc.nextLine();

            System.out.print("Item Value: ");
            double value = sc.nextDouble();
            sc.nextLine(); // consume newline

            if (isValid(name, id, value)) {
                cartList.add(new Cart(name, id, value));
            } else {
                System.out.println("Invalid item. Skipping...");
            }
        }

        int itemsCount = cartList.size();
        double orderTotal = 0;
        for (Cart c : cartList) {
            orderTotal += c.itemValue;
        }

        System.out.println("\nOrder Summary:");
        System.out.println("Items Count: " + itemsCount);
        System.out.println("Order Total: ₹" + orderTotal);

        sc.close();
    }

    static boolean isValid(String name, String id, double value) {
        return name != null && !name.isEmpty()
            && id != null && !id.isEmpty()
            && value > 0;
    }
}

class Cart {
    String itemName;
    String itemId;
    double itemValue;

    public Cart(String itemName, String itemId, double itemValue) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.itemValue = itemValue;
    }
}
