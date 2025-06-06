import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}

public class FindEmployeeDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditya", "IT"),
            new Employee("Jay", "HR"),
            new Employee("Chaman", "Finance")
        );
      
        Optional<Employee> firstEmployee = employees.stream().findFirst();
        firstEmployee.ifPresent(emp -> 
            System.out.println("First Employee: " + emp)
        );

        Optional<Employee> anyEmployee = employees.stream().findAny();
        anyEmployee.ifPresent(emp -> 
            System.out.println("Any Employee: " + emp)
        );
    }
}
