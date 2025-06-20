import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.function.Consumer;

public class LegacyApiWrapper {
    @FunctionalInterface
    public interface IOConsumer<T> {
        void accept(T t) throws IOException;
    }
    public static <T> Consumer<T> wrapIOConsumer(IOConsumer<T> ioConsumer) {
        return t -> {
            try {
                ioConsumer.accept(t);
            } catch (IOException e) {
                throw new UncheckedIOException("Wrapped IOException", e);
            }
        };
    }
    public static void legacyMethod(String input) throws IOException {
        if (input.equals("fail")) {
            throw new IOException("Legacy failure for input: " + input);
        }
        System.out.println("Processed input: " + input);
    }

    public static void main(String[] args) {
        Consumer<String> safeConsumer = wrapIOConsumer(LegacyApiWrapper::legacyMethod);

        String[] testInputs = {"hello", "fail", "world"};

        for (String input : testInputs) {
            try {
                safeConsumer.accept(input);
            } catch (UncheckedIOException e) {
                System.out.println("Caught UncheckedIOException: " + e.getMessage());
            }
        }
    }
}
