
package Database;

import java.sql.Connection;
import java.sql.Statement;

public class AddStudent {
    public boolean addStudentToDatabase(Database database,String rollNo, String name, String email, String className, String mobileNo) {
        Connection c=database.getConnection();
        try {
            Statement stmt = c.createStatement();
            String sql = "INSERT INTO student(rollno, name, email, classname, mobileno) "
                    + "VALUES ('" + rollNo + "', '" + name + "', '" + email + "', '" + className + "', '" + mobileNo + "' );";
            stmt.executeUpdate(sql);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return false;
    }
}
