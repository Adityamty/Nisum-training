import java.sql.*;

public class InsertStudentPreparedSafe {

    private static final String URL  = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "your_user";
    private static final String PASS = "your_password";

    public static void main(String[] args) {

        String createSQL =
            "CREATE TABLE IF NOT EXISTS students (" +
            "id INT PRIMARY KEY, " +
            "name VARCHAR(100), " +
            "age INT)";

        String insertSQL =
            "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";

        
        int    id   = 7;
        String name = "Leena";
        int    age  = 23;

        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(createSQL);
            }

            
            try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setInt(3, age);

                int rows = ps.executeUpdate();
                System.out.println(rows == 1
                        ? "Insert successful."
                        : "Insert failed.");
            }

        } catch (SQLException ex) {
        
            System.err.println("SQLState : " + ex.getSQLState());
            System.err.println("ErrorCode: " + ex.getErrorCode());
            System.err.println("Message  : " + ex.getMessage());
        }
    }
}
