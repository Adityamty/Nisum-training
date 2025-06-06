import java.util.*;

class Employee {
    private String name;
    private Optional<String> department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = Optional.ofNullable(department);
        this.salary = salary;
    }

    public Optional<String> getDepartment() {
        return department;
    }

    public void increaseSalary(double amount) {
        this.salary += amount;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void printDetails() {
        System.out.println(name + " | Dept: " + department.orElse("None") + " | Salary: " + salary);
    }
}

public class SalaryUpdate {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditya", "IT", 60000),
            new Employee("Soumili", "HR", 50000),
            new Employee("Megha", "IT", 65000),
            new Employee("Dina", null, 55000)
        );

        for (Employee emp : employees) {
            emp.getDepartment().ifPresent(dept -> {
                if (dept.equalsIgnoreCase("IT")) {
                    emp.increaseSalary(5000); 
                }
            });
        }
        employees.forEach(Employee::printDetails);
    }
}
