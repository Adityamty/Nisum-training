import java.util.*;
import java.util.stream.Collectors;

class Address {
    private String city;
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

class Employee {
    private String firstName;
    private String lastName;
    private Address address;

    public Employee(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFullName() {
        return firstName + lastName;
    }

    public Address getAddress() {
        return address;
    }
}

public class MapByFullName {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditya", "Mohanty", new Address("New York", "USA")),
            new Employee("Idris", "Elba", new Address("London", "UK")),
            new Employee("Raj", "Sharma", new Address("Delhi", "India"))
        );

        Map<String, Address> employeeMap = employees.stream()
            .collect(Collectors.toMap(
                Employee::getFullName,
                Employee::getAddress
            ));
        employeeMap.forEach((key, value) ->
            System.out.println(key + " -> " + value)
        );
    }
}
