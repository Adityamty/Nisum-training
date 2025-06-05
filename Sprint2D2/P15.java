import java.util.Optional;

class Address {
    private String city;
    private String state;

    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return city + ", " + state;
    }
}

class Employee {
    private int id;
    private String name;
    private Optional<Address> address;

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = Optional.ofNullable(address);
    }

    public void printDetails() {
        Address defaultAddress = new Address("Unknown City", "Unknown State");
        Address addr = address.orElse(defaultAddress);

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + addr);
    }
}

public class OptionalAddressDemo {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Aditya", new Address("Bangalore", "Karnataka"));
        Employee emp2 = new Employee(102, "Megha", null); 

        emp1.printDetails();
        System.out.println("-----------");
        emp2.printDetails();
    }
}
