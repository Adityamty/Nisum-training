class Parent {
    static void display() {
        System.out.println("Static method in Parent class");
    }
}

class Child extends Parent {
    public static void main(String[] args) {
        Parent.display(); // accessing static method using parent class name
        display();        // accessing directly from child class
    }
}
