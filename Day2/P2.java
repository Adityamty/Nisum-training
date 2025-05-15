import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private String grade;

    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + " | Name: " + name + " | Grade: " + grade);
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Method to add a new student
    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        studentList.add(new Student(id, name, grade));
        System.out.println("Student added successfully.\n");
    }

    // Method to remove a student by ID
    public static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        String id = scanner.nextLine();
        boolean removed = studentList.removeIf(student -> student.getId().equals(id));
        if (removed) {
            System.out.println("Student removed successfully.\n");
        } else {
            System.out.println("Student ID not found.\n");
        }
    }

    // Method to search for a student by ID
    public static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                student.displayInfo();
                return;
            }
        }
        System.out.println("Student ID not found.\n");
    }

    // Method to display all students
    public static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.\n");
            return;
        }
        System.out.println("\nAll Students:");
        for (Student student : studentList) {
            student.displayInfo();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("===== Student Management Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> removeStudent();
                case 3 -> searchStudent();
                case 4 -> displayAllStudents();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Try again.\n");
            }
        } while (choice != 0);
    }
}
