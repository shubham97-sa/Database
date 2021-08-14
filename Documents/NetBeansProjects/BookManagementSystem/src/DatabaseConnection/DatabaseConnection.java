
package DatabaseConnection;
import java .sql.*;



public class DatabaseConnection {
 String url;
 String username;
 String password;
 
 public DatabaseConnection(String url, String username, String password){
     this.url=url;
     this.username=username;
     this.password=password;
     
 }
public Connection getConnection() {
    Connection con=null;
    try{
        
        Class.forName("org.postgresql.Driver");
        con=DriverManager.getConnection(url,username,password);
    //        con.close();
        return con;
        
    }catch(ClassNotFoundException | SQLException e){
        System.out.println(e);
        System.exit(0);
        
    }

     return con;
    
    
    
}
    
   

}

    
//    public Connection connect(){
//        Connection connection=null;
//        try{
//            Class.forName("org.postgresql.Driver");
//            connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/bookmanagement","postgres","17241231");
//            
//        }catch(ClassNotFoundException | SQLException e){
//            System.out.println(e.getMessage());
//           
//            
//        }
//        return connection;
//        
//    }
    

