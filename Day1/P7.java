class StaticFlow {
    static {
        System.out.println("Static block executed first");
    }

    static int staticVariable = 10;

    static void staticMethod() {
        System.out.println("Static method executed");
    }

    public static void main(String[] args) {
        System.out.println("Main method executed");
        StaticFlow.staticMethod();
    }
}
