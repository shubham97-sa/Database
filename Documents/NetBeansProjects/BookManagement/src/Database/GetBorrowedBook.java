
package Database;

import Modules.BookModule;
import Modules.StudentModule;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


public class GetBorrowedBook {
    public ArrayList<BookModule> getBorrowedBooksByStudent(Database database,StudentModule student){
        Connection c=database.getConnection();
        ArrayList<BookModule> books = new ArrayList<BookModule>();        
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select bk.id,bk.bookname,bk.author,bk.subject,bk.copies,bk.publishdate from borrow br join book bk on br.bookid=bk.id where br.returndate is null and br.studentid="+student.getId());
            while (rs.next()) {
                int id = rs.getInt("id");
                String bookname = rs.getString("bookname");
                String author = rs.getString("author");
                String subject = rs.getString("subject");
                int copies = rs.getInt("copies");
                Date publisheddate=rs.getDate("publishdate");
                BookModule book = new BookModule(id, bookname, author, subject, copies, publisheddate);
                books.add(book);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return books;
    }
    
    public int getBorrowedBook(Database database,int bookid,String rollNo) {
        Connection c=database.getConnection();
        int borrowid=-1;
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select b.id from borrow b join student s on b.studentid=s.id where b.returndate is null and b.bookid="+bookid+" and s.rollno='"+rollNo+"'");
            if (rs.next()) {
                borrowid = rs.getInt("id");               
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return borrowid;
    }
}
