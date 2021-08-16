
package Database;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReturnBook {
    public boolean returnBook(Database database,int borrowid, Date returnDate) {
        Connection c=database.getConnection();
        try {
            Statement stmt = c.createStatement();
            SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
            String sql = "UPDATE borrow SET returndate= '" + dt1.format(returnDate) + "' Where id="+borrowid+"";                       
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