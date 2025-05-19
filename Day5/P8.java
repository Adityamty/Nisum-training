import java.sql.*;

public class TwoTableTransaction {
    private static final String URL  = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "your_user";
    private static final String PASS = "your_password";

    public static void main(String[] args) {
        String insertStudent = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        String insertPayment = "INSERT INTO fees (student_id, amount) VALUES (?, ?)";

        int id = 10;
        String name = "Maya";
        int age = 19;
        double fee = 1200.0;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            conn.setAutoCommit(false);               

            try (PreparedStatement psStud = conn.prepareStatement(insertStudent);
                 PreparedStatement psFee  = conn.prepareStatement(insertPayment)) {

                // Insert into students
                psStud.setInt(1, id);
                psStud.setString(2, name);
                psStud.setInt(3, age);
                int rows1 = psStud.executeUpdate();

                // Insert related fee record
                psFee.setInt(1, id);
                psFee.setDouble(2, fee);
                int rows2 = psFee.executeUpdate();

                if (rows1 == 1 && rows2 == 1) {
                    conn.commit();
                    System.out.println("Transaction committed.");
                } else {
                    conn.rollback();
                    System.out.println("Insert affected unexpected rows—rolled back.");
                }
            } catch (SQLException ex) {
                conn.rollback();
                System.out.println("Error during insert—rolled back.");
                ex.printStackTrace();
            } finally {
                conn.setAutoCommit(true);            
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
