package Database;

import Modules.StudentModule;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MoreThan15Days {
    public ArrayList<StudentModule> getMoreThan15DaysList(Database database) {
        Connection c=database.getConnection();
        ArrayList<StudentModule> students = new ArrayList<>();
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select s.id,s.rollno,s.name,s.email,s.classname,s.mobileno from borrow b join student s on b.studentid=s.id where returndate is null and DATE_PART('day', now() - borrowdate)>15");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String rollno = rs.getString("rollno");
                String email = rs.getString("email");
                String classname = rs.getString("classname");
                String mobileno = rs.getString("mobileno");
                StudentModule student = new StudentModule(id, rollno, name, email, classname, mobileno);
                students.add(student);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return students;
    }
}
