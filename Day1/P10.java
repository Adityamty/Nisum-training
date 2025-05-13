class StaticMethodOverloading {
    static void display() {
        System.out.println("No arguments");
    }

    static void display(int a) {
        System.out.println("Integer: " + a);
    }

    static void display(String s) {
        System.out.println("String: " + s);
    }

    public static void main(String[] args) {
        display();
        display(100);
        display("Hello");
    }
}
