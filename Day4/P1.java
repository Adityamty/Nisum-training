import java.sql.*;


public class JdbcConnectionDemo {

    
    private static final String URL      = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER     = "your_user";
    private static final String PASSWORD = "your_password";

   
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

  
    public static void main(String[] args) {
        
        try (Connection conn = getConnection()) {
            if (conn == null) {
                System.err.println("Failed to establish database connection.");
                return;
            }
            System.out.println("Connection successful!  Catalog = " + conn.getCatalog());
            String sql = "SELECT VERSION() AS version";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    System.out.println("MySQL Server Version: " + rs.getString("version"));
                }
            }

        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }
}
