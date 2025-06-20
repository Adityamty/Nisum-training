class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {

    
    public static void validateAge(int age) {
        try {
            if (age <= 0) {
                throw new InvalidAgeException("Invalid age: Age must be greater than 0");
            } else {
                System.out.println("Valid age: " + age);
            }
        } catch (InvalidAgeException e) {
            
            throw e;
        }
    }

    
    public static void main(String[] args) {
        int[] testAges = {25, 0, -10, 45};

        for (int age : testAges) {
            try {
                System.out.println("Checking age: " + age);
                validateAge(age);
            } catch (InvalidAgeException e) {
                System.out.println("Caught InvalidAgeException: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Caught some other Exception: " + e.getMessage());
            }
            System.out.println("----------");
        }
    }
}
