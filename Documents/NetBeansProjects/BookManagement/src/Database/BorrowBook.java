
package Database;

import Modules.BookModule;
import Modules.StudentModule;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowBook {
    public boolean borrowBook(Database database,BookModule book, StudentModule student, Date borrowDate) {
        Connection c=database.getConnection();
        try {
            Statement stmt = c.createStatement();
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            String sql = "INSERT INTO borrow(bookid, studentid, borrowdate) "
                    + "VALUES (" + book.getId() + ", " + student.getId() + ", '" + dt1.format(borrowDate) + "' );";
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
