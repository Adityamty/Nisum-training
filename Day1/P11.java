import java.util.regex.*;

class ValidationUtil {
    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return username.matches(regex);
    }

    public static boolean isValidPassword(String password) {
        String regex = "(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}";
        return password.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(isValidUsername("user@example.com"));  // true
        System.out.println(isValidPassword("Password123@"));     // true
    }
}
