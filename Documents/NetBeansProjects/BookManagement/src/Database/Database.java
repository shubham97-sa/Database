
package Database;
import java.sql.*;

public class Database {
    String host = "localhost:5432";
    String databasename = "bookmanagement";
    String username = "postgres";
    String password = "17241231";
    Connection c = null;
    
    public Database() {
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://" + host + "/" + databasename, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    public Connection getConnection(){
        return c;
    }
    
    
}
