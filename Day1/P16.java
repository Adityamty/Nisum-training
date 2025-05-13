class Nisum {
    String company = "Nisum Technologies";

    public void displayCompany() {
        System.out.println("Company: " + company);
    }
}

class Employee extends Nisum {
    public void displayEmployeeInfo() {
        // Directly accessing inherited instance variable
        System.out.println("Employee works at: " + company);
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.displayEmployeeInfo();
    }
}
