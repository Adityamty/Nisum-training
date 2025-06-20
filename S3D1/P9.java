import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ValidationFramework {

    public static class ValidationException extends RuntimeException {
        private final List<String> errors;

        public ValidationException(List<String> errors) {
            super("Validation failed with " + errors.size() + " error(s).");
            this.errors = errors;
        }

        public List<String> getErrors() {
            return errors;
        }
    }

    @FunctionalInterface
    public interface Validator<T> {
        List<String> validate(T object);
    }

    public record User(String name, int age, String email) {}

    public static class UserValidator implements Validator<User> {
        @Override
        public List<String> validate(User user) {
            List<String> errors = new ArrayList<>();

            if (user.name() == null || user.name().isBlank()) {
                errors.add("Name must not be empty.");
            }

            if (user.age() <= 0) {
                errors.add("Age must be greater than 0.");
            }

            if (user.email() == null || !isValidEmail(user.email())) {
                errors.add("Email is invalid.");
            }

            return errors;
        }

        private boolean isValidEmail(String email) {
            String regex = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";
            return Pattern.matches(regex, email);
        }
    }

    public static class ValidationEngine {
        public static <T> void runValidation(T object, Validator<T> validator) {
            List<String> errors = validator.validate(object);
            if (!errors.isEmpty()) {
                throw new ValidationException(errors);
            }
            System.out.println("Validation passed for: " + object);
        }
    }

    public static void main(String[] args) {
        User validUser = new User("Alice", 25, "alice@example.com");
        User invalidUser = new User("", -10, "invalid-email");

        try {
            System.out.println("Validating valid user...");
            ValidationEngine.runValidation(validUser, new UserValidator());
        } catch (ValidationException e) {
            System.out.println("Validation failed:");
            e.getErrors().forEach(System.out::println);
        }

        System.out.println();

        try {
            System.out.println("Validating invalid user...");
            ValidationEngine.runValidation(invalidUser, new UserValidator());
        } catch (ValidationException e) {
            System.out.println("Validation failed:");
            e.getErrors().forEach(System.out::println);
        }
    }
}
