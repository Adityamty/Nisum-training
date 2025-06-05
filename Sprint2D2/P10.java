import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;

    // Constructor
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name=" + name + ", department=" + department + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        // Full employee list
        List<Employee> allEmployees = Arrays.asList(
            new Employee(101, "Alice", "HR"),
            new Employee(102, "Bob", "IT"),
            new Employee(103, "Charlie", "Finance"),
            new Employee(104, "David", "Marketing"),
            new Employee(105, "Eva", "Engineering")
        );

        // IDs to filter
        List<Integer> targetIds = Arrays.asList(102, 104);

        // Filter matching employees
        List<Employee> matchedEmployees = allEmployees.stream()
            .filter(emp -> targetIds.contains(emp.getId()))
            .collect(Collectors.toList());

        // Output
        matchedEmployees.forEach(System.out::println);
    }
}
