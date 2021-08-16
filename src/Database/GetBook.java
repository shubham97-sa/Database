
package Database;

import Modules.BookModule;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;


public class GetBook {
    public BookModule getBook(Database database,String bookname, String author) {
        Connection c=database.getConnection();
        BookModule book = null;        
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BOOK WHERE bookname='" + bookname + "' AND author='"+author+"'");
            if (rs.next()) {
                int id = rs.getInt("id");
                String subject = rs.getString("subject");
                int copies = rs.getInt("copies");
                Date publisheddate=rs.getDate("publishdate");
                book = new BookModule(id, bookname, author, subject, copies, publisheddate);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return book;
    }
    public BookModule getBookById(Database database,int id) {
        Connection c=database.getConnection();
        BookModule book = null;        
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BOOK WHERE id="+id);
            if (rs.next()) {
                String bookname = rs.getString("bookname");
                String author = rs.getString("author");
                String subject = rs.getString("subject");
                int copies = rs.getInt("copies");
                Date publisheddate=rs.getDate("publishdate");
                book = new BookModule(id, bookname, author, subject, copies, publisheddate);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return book;
    }
}
