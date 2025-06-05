import java.util.*;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return name + " (" + salary + ")";
    }
}

public class SortBySalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditya", 60000),
            new Employee("Bhuvi", 50000),
            new Employee("Chahal", 70000),
            new Employee("Dina", 55000)
        );

        employees.sort(Comparator.comparingDouble(Employee::getSalary));

      
        employees.forEach(System.out::println);
    }
}
