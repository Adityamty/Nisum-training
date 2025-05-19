import java.sql.*;
import java.util.Scanner;

public class DeleteStudentById {
    public static void main(String[] args) {
        String url  = "jdbc:mysql://localhost:3306/jdbc";
        String user = "your_user";
        String pass = "your_password";

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter student ID to delete: ");
            int id = sc.nextInt();

            String deleteSQL = "DELETE FROM students WHERE id = ?";

            try (Connection conn = DriverManager.getConnection(url, user, pass);
                 PreparedStatement ps = conn.prepareStatement(deleteSQL)) {

                ps.setInt(1, id);                 
                int rows = ps.executeUpdate();    
                System.out.println(rows == 1
                        ? "Delete successful."
                        : "No student found with that ID.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
