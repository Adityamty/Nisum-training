import java.sql.*;
import java.util.Scanner;


public class SearchStudentsWildcard {
    private static final String URL  = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "your_user";
    private static final String PASS = "your_password";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter starting letters of the name: ");
            String input = sc.nextLine().trim();     
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty.");
                return;
            }
            String pattern = input + "%";           

            String sql = "SELECT id, name, age FROM students WHERE name LIKE ?";

            try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, pattern);            
                try (ResultSet rs = ps.executeQuery()) {
                    System.out.println("Results:");
                    boolean any = false;
                    while (rs.next()) {
                        any = true;
                        System.out.printf("%d\t%s\t%d%n",
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("age"));
                    }
                    if (!any) System.out.println("No matching students found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
