import java.util.TreeSet;

class Employee implements Comparable<Employee> {
    int id;
    String name, department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Dept: " + department + " | Salary: $" + salary;
    }
}

public class EmployeeRecordsDemo {
    public static void main(String[] args) {
        TreeSet<Employee> employees = new TreeSet<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 60000));
        employees.add(new Employee(103, "Charlie", "Finance", 55000));

        System.out.println("Sorted Employee Records:");
        employees.forEach(System.out::println);
    }
}
