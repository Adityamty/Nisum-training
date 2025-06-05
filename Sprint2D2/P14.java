import java.util.Optional;

class Employee {
    private int id;
    private String name;
    private double salary;
    private Optional<String> email;       
    private Optional<String> phoneNumber; 

    public Employee(int id, String name, double salary, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.email = Optional.ofNullable(email);
        this.phoneNumber = Optional.ofNullable(phoneNumber);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    public Optional<String> getEmail() { return email; }
    public Optional<String> getPhoneNumber() { return phoneNumber; }

    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Email: " + email.orElse("Not Provided"));
        System.out.println("Phone: " + phoneNumber.orElse("Not Provided"));
    }
}

public class OptionalEmployeeDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Aditya", 55000, "Aditya@gmail.com", null);
        Employee emp2 = new Employee(102, "Megha", 60000, null, "9876543210");

        emp1.printDetails();
        System.out.println("-----------");
        emp2.printDetails();
    }
}
