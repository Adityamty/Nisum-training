import java.sql.*;

public class UpdateStudentName {
    public static void main(String[] args) {
        String url  = "jdbc:mysql://localhost:3306/your_db?useSSL=false&serverTimezone=UTC";
        String user = "your_user";
        String pass = "your_password";

        String update = "UPDATE students SET name = ? WHERE id = ?";

        int    id   = 2;          
        String name = "Robert";   

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement ps = conn.prepareStatement(update)) {

            ps.setString(1, name); 
            ps.setInt(2, id);      

            int rows = ps.executeUpdate();
            System.out.println(rows == 1 ? "Update successful." : "No matching student found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
