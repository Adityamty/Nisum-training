import java.util.*;

class Employee {
    private String firstName;
    private String lastName;

    public Employee(String first, String last) {
        this.firstName = first;
        this.lastName = last;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", "Doe"),
            new Employee("Jane", "Smith")
        );

        if (!employees.isEmpty()) {
            Employee first = employees.get(0);
            String fullName = first.getFirstName() + " " + first.getLastName();
            System.out.println(fullName);
        }
    }
}
