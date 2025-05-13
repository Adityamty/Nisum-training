class Student {
    private static String college = "XYZ University";
    private static int rollNumber;
    private String name;
    private String address;
    private String section;

    public Student(String name, String address, String section, int rollNumber) {
        this.name = name;
        this.address = address;
        this.section = section;
        if(Student.rollNumber == 0) {
            Student.rollNumber = rollNumber;  // Ensure roll number is assigned only once
        }
    }

    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Section: " + section);
        System.out.println("College: " + college);
        System.out.println("Roll Number: " + rollNumber);
    }
}
