import java.sql.*;

public class CreditTransfer {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "your_user";
    private static final String PASSWORD = "your_password";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

   
    public static boolean transferCredits(int fromStudentId, int toStudentId, int credits) {
        String deductSql = "UPDATE students SET credits = credits - ? WHERE id = ? AND credits >= ?";
        String addSql = "UPDATE students SET credits = credits + ? WHERE id = ?";

        try (Connection conn = getConnection()) {
            conn.setAutoCommit(false); 

            try (PreparedStatement deductStmt = conn.prepareStatement(deductSql);
                 PreparedStatement addStmt = conn.prepareStatement(addSql)) {

                
                deductStmt.setInt(1, credits);
                deductStmt.setInt(2, fromStudentId);
                deductStmt.setInt(3, credits);
                int rowsAffected = deductStmt.executeUpdate();
                if (rowsAffected == 0) {
                    conn.rollback();
                    System.out.println("Insufficient credits to transfer.");
                    return false;
                }

                
                addStmt.setInt(1, credits);
                addStmt.setInt(2, toStudentId);
                rowsAffected = addStmt.executeUpdate();
                if (rowsAffected == 0) {
                    conn.rollback();
                    System.out.println("Receiver student ID not found.");
                    return false;
                }

                conn.commit(); 
                return true;

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                return false;
            } finally {
                conn.setAutoCommit(true); 
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
