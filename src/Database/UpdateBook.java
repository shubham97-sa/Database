
package Database;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;


public class UpdateBook {
    public boolean updateBook(Database database,int id,String bookname, String author, String subject, int copies, java.util.Date publisheddate) {
        Connection c=database.getConnection();
        try {
            Statement stmt = c.createStatement();
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            String sql = "UPDATE BOOK SET  bookname='" + bookname + 
                    "', author='" + author + "', subject='" + subject + "', copies=" + copies + 
                    ", publishdate='" + dt1.format(publisheddate) + "' WHERE id="+id;
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
