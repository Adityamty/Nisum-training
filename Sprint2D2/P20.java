import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    private String department;
    private String email;

    public Employee(String name, String department, String email) {
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getEmail() { return email; }
}

public class MatchDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditya", "IT", "aditya@gmail.com"),
            new Employee("Bimal", "HR", "bimal@gmail.com"),
            new Employee("Jay", "Finance", "jay@gmail.com"),
            new Employee(null, "IT", "nullname@gmail.com")
        );

      
        boolean hasHR = employees.stream()
                .anyMatch(e -> "HR".equalsIgnoreCase(e.getDepartment()));
        System.out.println("Any employee from HR? " + hasHR);

        
        boolean allHaveEmail = employees.stream()
                .allMatch(e -> e.getEmail() != null && !e.getEmail().isEmpty());
        System.out.println("All employees have email? " + allHaveEmail);

      
        boolean noNullNames = employees.stream()
                .noneMatch(e -> e.getName() == null);
        System.out.println("No employee has null name? " + noNullNames);
    }
}
