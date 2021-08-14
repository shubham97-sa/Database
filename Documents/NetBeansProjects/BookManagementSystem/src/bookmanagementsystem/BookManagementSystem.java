
package bookmanagementsystem;
import DatabaseConnection.DatabaseConnection;
import Details.BookDetails;
import java.sql.Connection;


public class BookManagementSystem {

   
    public static void main(String[] args) {
        BookDetails bd=new BookDetails();
        bd.getBookDetails();
        bd.insertBookDetails();
       

    }
    
}
