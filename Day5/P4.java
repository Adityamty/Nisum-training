import java.sql.*;

public class InsertStudentPrepared {
    public static void main(String[] args) {
        String url  = "jdbc:mysql://localhost:3306/jdbc";
        String user = "your_user";
        String pass = "your_password";

        String create = """
            CREATE TABLE IF NOT EXISTS students (
                id   INT PRIMARY KEY,
                name VARCHAR(100),
                age  INT)
            """;

        String insert = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";

        int id = 2;
        String name = "Bob";
        int age = 21;

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement  stmt = conn.createStatement()) {

            stmt.executeUpdate(create); 

            try (PreparedStatement ps = conn.prepareStatement(insert)) {
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, age);

                int rows = ps.executeUpdate();
                System.out.println(rows == 1 ? "Insert successful." : "Insert failed.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
