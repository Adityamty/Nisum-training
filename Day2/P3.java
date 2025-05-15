
import java.util.HashSet;
import java.util.Scanner;

public class EmailDuplicateRemover {
    private static HashSet<String> emailSet = new HashSet<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void addEmail() {
        System.out.print("Enter email address to add: ");
        String email = scanner.nextLine().trim().toLowerCase(); 

        if (emailSet.add(email)) {
            System.out.println("Email added successfully.\n");
        } else {
            System.out.println("Duplicate email. Not added.\n");
        }
    }


    public static void displayEmails() {
        if (emailSet.isEmpty()) {
            System.out.println("No email addresses found.\n");
            return;
        }

        System.out.println("Unique Email Addresses:");
        for (String email : emailSet) {
            System.out.println(email);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("=== Email Duplicate Remover Menu ===");
            System.out.println("1. Add Email");
            System.out.println("2. Show Unique Emails");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addEmail();
                case 2 -> displayEmails();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.\n");
            }
        } while (choice != 0);
    }
}
