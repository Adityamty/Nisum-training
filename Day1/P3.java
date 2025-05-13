import java.util.Scanner;

public class UserProfile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Country: ");
        String country = sc.nextLine();

        User user = new User(name, age, email, country);

        System.out.println("\nUser Profile Created:");
        System.out.println(user);
        
        sc.close();
    }
}

class User {
    private String name;
    private int age;
    private String email;
    private String country;

    public User(String name, int age, String email, String country) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Name: " + name +
               "\nAge: " + age +
               "\nEmail: " + email +
               "\nCountry: " + country;
    }
}
