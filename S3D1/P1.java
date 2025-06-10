import java.util.Scanner;

public class DivisionDemo {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return dividend / divisor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.print("Enter the dividend: ");
            int dividend = scanner.nextInt();
            System.out.print("Enter the divisor: ");
            int divisor = scanner.nextInt();
            int result = divide(dividend, divisor);
            System.out.println("Result: " + dividend + " ÷ " + divisor + " = " + result);

        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid input.");
        } finally {
            scanner.close(); 
        }
    }
}
