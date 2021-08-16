
package Database;

import java.sql.Connection;
import java.sql.Statement;

public class DeleteBook {
    public boolean deleteBook(Database database,int id) {
        Connection c=database.getConnection();
        try {
            Statement stmt = c.createStatement();            
            String sql = "DELETE FROM book where id="+id;
            stmt.executeUpdate(sql);
            stmt.close();
            stmt = c.createStatement();            
            sql = "DELETE FROM borrow where bookid="+id;
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
