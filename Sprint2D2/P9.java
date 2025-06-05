import java.util.ArrayList;
import java.util.List;

class Employee {
    private String firstName;
    private String lastName;
    private String department;

    public Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }


    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getDepartment() {
        return department;
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        
        employees.add(new Employee("Aditi", "Patel", "HR"));
        employees.add(new Employee("Ayush", "Arora", "Finance"));
        employees.add(new Employee("Mayank", "Aggarwal", "Engineering"));
        employees.add(new Employee("Sonali", "Pradhan", "Marketing"));
        employees.add(new Employee("Chirayu", "Jena", "Sales"));
        employees.add(new Employee("Aditya", "Mohanty", "IT"));
        employees.add(new Employee("Lalit", "Vasishtha", "Admin"));
        employees.add(new Employee("Ohjaswi", "Aggarwal", "Legal")); 
        employees.add(new Employee("Natraj", "Mishra", "Support"));
        employees.add(new Employee("Ananya", "Jena", "Design"));

      
        Employee eighthEmployee = employees.get(7);
        System.out.println("Full Name: " + eighthEmployee.getFullName());
        System.out.println("Department: " + eighthEmployee.getDepartment());
    }
}
