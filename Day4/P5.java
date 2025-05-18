import java.sql.*;
import java.util.ArrayList;
import java.util.List;

record CourseResult(String courseName, String instructor,
                    String semester, String grade) {}

public class CourseLookup {

    private static final String URL      = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER     = "your_user";
    private static final String PASSWORD = "your_password";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static List<CourseResult> getCoursesByStudent(int studentId) {
        String sql = """
            SELECT c.course_name,
                   c.instructor,
                   e.semester,
                   e.grade
              FROM enrollments e
              JOIN courses      c ON c.id = e.course_id
             WHERE e.student_id = ?
             ORDER BY e.semester DESC
        """;

        List<CourseResult> results = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    results.add(new CourseResult(
                            rs.getString("course_name"),
                            rs.getString("instructor"),
                            rs.getString("semester"),
                            rs.getString("grade")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static void main(String[] args) {
        List<CourseResult> list = getCoursesByStudent(1); 
        list.forEach(System.out::println);
    }
}
