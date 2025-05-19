import java.sql.*;

public class CallGetStudentById {
    private static final String URL  = "jdbc:mysql://localhost:3306/your_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "your_user";
    private static final String PASS = "your_password";

    public static void main(String[] args) {
        int id = 3;  

        String call = "{call getStudentById(?)}";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             CallableStatement cs = conn.prepareCall(call)) {

            cs.setInt(1, id);               
            boolean hasResult = cs.execute();  

            if (hasResult) {
                try (ResultSet rs = cs.getResultSet()) {
                    if (rs.next()) {
                        System.out.printf("ID: %d  Name: %s  Age: %d%n",
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("age"));
                    } else {
                        System.out.println("No student found.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
