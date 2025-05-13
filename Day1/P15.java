class Student {
    private String name;
    private String college;
    private String[] subjects = new String[3];
    private int[] marks = new int[3];

    public Student(String name, String college, String[] subjects, int[] marks) {
        this.name = name;
        this.college = college;
        this.subjects = subjects;
        this.marks = marks;
    }

    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("College: " + college);
        System.out.println("Subjects and Marks:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + marks[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String[] subjects = {"Math", "Science", "English"};
        int[] marks = {90, 85, 88};
        Student student = new Student("John Doe", "XYZ College", subjects, marks);
        student.displayStudentInfo();
    }
}
