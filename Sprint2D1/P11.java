interface InterfaceA {
    default void run() {
        System.out.println("Running from InterfaceA");
    }
}

interface InterfaceB {
    default void run() {
        System.out.println("Running from InterfaceB");
    }
}

public class MyClass implements InterfaceA, InterfaceB {

    @Override
    public void run() {
    
        InterfaceA.super.run();  
        InterfaceB.super.run();  
        

        System.out.println("Running from MyClass");
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.run();
    }
}
