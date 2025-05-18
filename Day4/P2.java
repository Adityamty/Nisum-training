import java.sql.*;

class Student {
    int id;
    String name;
    String email;

    Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}

public class StudentQueryDemo {

    private static final String URL      = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER     = "your_user";
    private static final String PASSWORD = "your_password";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Student getStudentById(int studentId) {
        String sql = "SELECT id, name, email FROM students WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }

    public static void main(String[] args) {
        Student s = getStudentById(1); 
        System.out.println(s != null ? "Student: " + s : "Student not found.");
    }
}
