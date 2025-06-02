import java.util.*;
import java.util.stream.*;

class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

public class Main {
    public static List<Employee> searchEmployees(Map<String, List<Employee>> map, String search) {
        String lowerSearch = search.toLowerCase();

        return map.values().stream()                    
                .flatMap(List::stream)                  
                .filter(e -> e.getFirstName().toLowerCase().contains(lowerSearch) ||
                             e.getLastName().toLowerCase().contains(lowerSearch))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Map<String, List<Employee>> deptMap = new HashMap<>();
        deptMap.put("HR", Arrays.asList(new Employee("John", "Doe"), new Employee("Alice", "Smith")));
        deptMap.put("Finance", Arrays.asList(new Employee("Jane", "Brown"), new Employee("Mike", "Johnson")));

        List<Employee> result = searchEmployees(deptMap, "jo");
        result.forEach(System.out::println);
    }
}
