public interface StringUtils {

    static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    static String capitalize(String s) {
        if (isNullOrEmpty(s)) {
            return s;
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
public class Main {
    public static void main(String[] args) {
        String str1 = "";
        String str2 = "hello";

        System.out.println(StringUtils.isNullOrEmpty(str1)); 
        System.out.println(StringUtils.capitalize(str2));   
    }
}
