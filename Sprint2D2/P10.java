import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;

    
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    
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
        
        List<Employee> allEmployees = Arrays.asList(
        employees.add(new Employee("Aditi", "Patel", "HR"));
        employees.add(new Employee("Ayush", "Arora", "Finance"));
        employees.add(new Employee("Mayank", "Aggarwal", "Engineering"));
        employees.add(new Employee("Sonali", "Pradhan", "Marketing"));
        employees.add(new Employee("Chirayu", "Jena", "Sales"));
        );

        
        List<Integer> targetIds = Arrays.asList(102, 104);

        
        List<Employee> matchedEmployees = allEmployees.stream()
            .filter(emp -> targetIds.contains(emp.getId()))
            .collect(Collectors.toList());

        
        matchedEmployees.forEach(System.out::println);
    }
}
