import java.util.Random;

public class RetryWithExponentialBackoff {
    public static void retry(Runnable operation, int maxRetries, long initialDelayMillis) {
        int attempt = 0;
        long delay = initialDelayMillis;

        while (attempt < maxRetries) {
            try {
                operation.run(); 
                System.out.println("Operation succeeded on attempt #" + (attempt + 1));
                return;
            } catch (RuntimeException e) {
                attempt++;
                System.out.println("Attempt #" + attempt + " failed: " + e.getMessage());

                if (attempt == maxRetries) {
                    System.out.println("All retry attempts failed. Giving up.");
                    throw e; 
                }

                try {
                    System.out.println("Retrying after " + delay + " ms...");
                    Thread.sleep(delay);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    System.out.println("Retry interrupted.");
                    return;
                }

                delay *= 2; 
            }
        }
    }
    public static void simulatedNetworkCall() {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Simulated network failure.");
        }
        System.out.println("Simulated network call succeeded.");
    }
    public static void main(String[] args) {
        try {
            retry(RetryWithExponentialBackoff::simulatedNetworkCall, 5, 1000);
        } catch (RuntimeException e) {
            System.out.println("Final failure: " + e.getMessage());
        }
    }
}
