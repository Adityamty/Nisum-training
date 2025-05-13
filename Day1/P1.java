public class p1 {
    public static void main(String[] args) {
        Example obj = new Example();

        System.out.println("Class Name: Example");
        System.out.println("Simple Name: Example");
        System.out.println("Is Interface: false");
        System.out.println("Superclass: java.lang.Object");

        System.out.println("Interfaces:");
        System.out.println(" - java.lang.Runnable");

        System.out.println("Methods:");
        System.out.println(" - show");
        System.out.println(" - sum");
        System.out.println(" - run");

        System.out.println("Fields:");
        System.out.println(" - id");
        System.out.println(" - name");
    }
}

class Example implements Runnable {
    private int id;
    private String name;

    public void show() {}
    public int sum(int a, int b) { return a + b; }
    public void run() {}
}
