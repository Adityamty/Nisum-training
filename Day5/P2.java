import java.sql.*;

public class InsertStudentStatement {
    public static void main(String[] args) {
        String url  = "jdbc:mysql://localhost:3306/jdbc";
        String user = "your_user";
        String pass = "your_password";

        String create = "CREATE TABLE IF NOT EXISTS students ("
                      + "id INT PRIMARY KEY, "
                      + "name VARCHAR(100), "
                      + "age INT)";

        int id = 1;
        String name = "Alice";
        int age = 20;
        String insert = "INSERT INTO students VALUES (" + id + ", '" + name + "', " + age + ")";

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement  stmt = conn.createStatement()) {

            stmt.executeUpdate(create);         
            int rows = stmt.executeUpdate(insert);
            System.out.println(rows == 1 ? "Insert successful." : "Insert failed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
