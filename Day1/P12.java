class InstanceAndStatic {
    int instanceVariable = 10;
    static int staticVariable = 20;

    static void staticMethod() {
        // Cannot directly access instance variable inside static method
        System.out.println("Static method accessed static variable: " + staticVariable);
    }

    void instanceMethod() {
        System.out.println("Instance method can access both instance and static variables: " + instanceVariable + ", " + staticVariable);
    }

    public static void main(String[] args) {
        staticMethod();
        InstanceAndStatic obj = new InstanceAndStatic();
        obj.instanceMethod();
    }
}
