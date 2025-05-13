class StaticOrderExample {
    static {
        System.out.println("Static block executed first");
    }

    static void staticMethod() {
        System.out.println("Static method executed");
    }

    public static void main(String[] args) {
        System.out.println("Main method executed");
        staticMethod();  // Calling static method
    }
}
