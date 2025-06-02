import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int empId;
    private String firstName;
    private String lastName;
    private String department;

    public Employee(int empId, String firstName, String lastName, String department) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public int getEmpId() { return empId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return empId + ": " + firstName + " " + lastName + " (" + department + ")";
    }
}

public class Main {

    // 1. Pad storeId with leading zeros to length 4
    public static String padStoreId(String storeId) {
        return String.format("%4s", storeId).replace(' ', '0');
    }

    // 2. Return employees NOT in given department
    public static List<Employee> excludeDepartment(List<Employee> employees, String dept) {
        return employees.stream()
                .filter(e -> !e.getDepartment().equalsIgnoreCase(dept))
                .collect(Collectors.toList());
    }

    // 3. Sort employees by first name
    public static List<Employee> sortByFirstName(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .collect(Collectors.toList());
    }

    // 4. Find employee with highest empId
    public static Optional<Employee> findHighestEmpId(List<Employee> employees) {
        return employees.stream()
                .max(Comparator.comparingInt(Employee::getEmpId));
    }

    public static void main(String[] args) {
        
        System.out.println("Padded storeId (23): " + padStoreId("23")); 


        List<Employee> employees = Arrays.asList(
            new Employee(101, "John", "Doe", "HR"),
            new Employee(102, "Jane", "Smith", "Finance"),
            new Employee(103, "Alice", "Johnson", "HR"),
            new Employee(104, "Mike", "Brown", "IT"),
            new Employee(105, "Bob", "Davis", "Finance")
        );

        
        System.out.println("\nEmployees NOT in HR:");
        excludeDepartment(employees, "HR").forEach(System.out::println);

    
        System.out.println("\nEmployees sorted by first name:");
        sortByFirstName(employees).forEach(System.out::println);

    
        Optional<Employee> maxEmp = findHighestEmpId(employees);
        System.out.println("\nEmployee with highest empId:");
        maxEmp.ifPresent(System.out::println);
    }
}
