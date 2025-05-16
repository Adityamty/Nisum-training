import java.util.*;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toString() {
        return name + " - " + category + " - $" + price;
    }
}

public class ProductSorter {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.00),
            new Product("Shampoo", "Personal Care", 4.99),
            new Product("TV", "Electronics", 800.00),
            new Product("Toothpaste", "Personal Care", 2.99),
            new Product("Bread", "Groceries", 1.99)
        );

  
        products.sort(Comparator
            .comparing((Product p) -> p.category)
            .thenComparing(p -> p.price));


        for (Product p : products) {
            System.out.println(p);
        }
    }
}
