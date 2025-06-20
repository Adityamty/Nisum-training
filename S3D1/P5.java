import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;

public class FileIntegerParser {

    public static void readAndParseFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    System.out.println("Parsed integer: " + number);
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format: " + line);
                }
            }

            System.out.println("Total valid integers parsed: " + count);

        } catch (IOException | NumberFormatException | EOFException e) {
            System.out.println("An error occurred: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "numbers.txt";  
        readAndParseFile(filePath);
    }
}
