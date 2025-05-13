class Vehicle {
    String brand = "Generic Vehicle";

    void displayInfo() {
        System.out.println("Vehicle brand: " + brand);
    }
}

class Car extends Vehicle {
    int wheels = 4;

    void displayInfo() {
        super.displayInfo();
        System.out.println("Car has " + wheels + " wheels");
    }
}

class Bus extends Vehicle {
    int wheels = 6;

    void displayInfo() {
        super.displayInfo();
        System.out.println("Bus has " + wheels + " wheels");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        Car c = new Car();
        Bus b = new Bus();

        v.displayInfo();
        c.displayInfo();
        b.displayInfo();
    }
}
