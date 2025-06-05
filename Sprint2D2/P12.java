import java.util.*;
import java.util.stream.Collectors;
class Employee {
    private String name;
    private String gender;
    public Employee(String name, String gender) {
        this.name = name;
        this.gender = gender.toUpperCase();
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
}
public class GroupEmployees {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", "male"),
            new Employee("Mike", "male"),
            new Employee("Alice", "female"),
            new Employee("Lily", "female")
        );
        Map<String, List<String>> grouped = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getGender,
                Collectors.mapping(Employee::getName, Collectors.toList())
            ));
        String maleStr = "MALE: [" + String.join("-", grouped.getOrDefault("MALE", List.of())) + "]";
        String femaleStr = "FEMALE: [" + String.join("-", grouped.getOrDefault("FEMALE", List.of())) + "]";

        String result = maleStr + ", " + femaleStr;
        System.out.println(result);
    }
}
