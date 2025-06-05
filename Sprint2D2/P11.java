import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String gender;

    public Employee(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }
}

public class GroupByGender {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Aditi", "Female"),
            new Employee("Bimal", "Male"),
            new Employee("Charayu", "Male"),
            new Employee("Dina", "Female"),
            new Employee("Eklavya", "Male")
        );

        Map<String, Long> genderCount = employees.stream()
            .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

      
        genderCount.forEach((gender, count) -> 
            System.out.println(gender + ": " + count)
        );
    }
}
