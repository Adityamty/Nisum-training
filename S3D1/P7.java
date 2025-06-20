import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class GlobalExceptionLogger {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            logExceptionToFile(thread, exception);
        });
        System.out.println("Program started...");
        int result = 10 / 0;
        System.out.println("Result: " + result);
    }
    private static void logExceptionToFile(Thread thread, Throwable exception) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("error.log", true))) {
            writer.println("Exception occurred at " + LocalDateTime.now());
            writer.println("Thread: " + thread.getName());
            writer.println("Exception: " + exception);
            for (StackTraceElement element : exception.getStackTrace()) {
                writer.println("\tat " + element);
            }
            writer.println("---------------------------------------------------");
            System.out.println("Unhandled exception logged to error.log");
        } catch (IOException e) {
            System.out.println("Failed to log exception: " + e.getMessage());
        }
    }
}
