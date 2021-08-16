
package Database;

import Modules.BookModule;
import Modules.StudentModule;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class GetStudent {
    public StudentModule getStudent(Database database,String rollno) {
        Connection c=database.getConnection();
        StudentModule student = null;
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT WHERE rollno='" + rollno + "'");
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String classname = rs.getString("classname");
                String mobileno = rs.getString("mobileno");
                student = new StudentModule(id, rollno, name, email, classname, mobileno);
                GetBorrowedBook getBorrowedBook=new GetBorrowedBook();
                ArrayList<BookModule> books =getBorrowedBook.getBorrowedBooksByStudent(database,student);
                student.setBorrowedBooks(books);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return student;
        
    }
}
