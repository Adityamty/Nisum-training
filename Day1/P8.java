class StaticBlockExample {
    static {
        System.out.println("Static block executed at class loading time");
    }

    public static void main(String[] args) {
        System.out.println("Main method executed");
    }
}
