import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidatorWithFile {

    
    public static void validateAge(int age) {
        if (age <= 0) {
            throw new InvalidAgeException("Invalid age: Age must be greater than 0");
        } else {
            System.out.println("Valid age: " + age);
        }
    }

    public static void main(String[] args) {
        String filePath = "ages.txt"; 

        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    int age = Integer.parseInt(line.trim());
                    System.out.println("Checking age: " + age);
                    validateAge(age);
                } catch (InvalidAgeException e) {
                    System.out.println("Caught InvalidAgeException: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Caught NumberFormatException: Invalid number format -> " + line);
                }
                System.out.println("----------");
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
