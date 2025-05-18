import java.sql.*;

public class ReadStudents {
    public static void main(String[] args) {
        String url  = "jdbc:mysql://localhost:3306/jdbc";
        String user = "your_user";
        String pass = "your_password";

        String select = "SELECT id, name, age FROM students";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement  stmt = conn.createStatement();
             ResultSet  rs   = stmt.executeQuery(select)) {

            
            System.out.println("ID\tName\t\tAge");
            System.out.println("------------------------");

        
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id + "\t" + name + "\t\t" + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
