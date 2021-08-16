
package Database;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class AddBook {
    public boolean addBookToDatabase(Database database,String bookname, String author, String subject, int copies, java.util.Date publisheddate) {
        Connection c=database.getConnection();
        try {
            Statement stmt = c.createStatement();
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            String sql = "INSERT INTO book(bookname, author, subject, copies, publishdate) "
                    + "VALUES ('" + bookname + "', '" + author + "', '" + subject + "', " + copies + ", '" + dt1.format(publisheddate) + "' );";
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
