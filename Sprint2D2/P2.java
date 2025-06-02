import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", "HR"),
            new Employee("Jane", "Finance"),
            new Employee("Tom", "HR"),
            new Employee("Anna", "IT"),
            new Employee("Mike", "Finance")
        );

        Map<String, Long> deptCount = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println(deptCount);
    }
}
