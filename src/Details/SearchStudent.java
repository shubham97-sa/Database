
package Details;
import Modules.StudentModule;
import Modules.BookModule;

import  Database.*;
import java.util.ArrayList;
import java.util.Scanner;
public class SearchStudent {
     public  void searchStudent(Database database) {
        System.out.println("You have chosen to search a student by roll number.");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter roll number: ");
        String rollno = input.nextLine();
        GetStudent getStudent=new GetStudent();
        StudentModule student = getStudent.getStudent(database,rollno);
        if (student == null) {
            System.out.println("There is no student with above details");
        } else {
            System.out.println(student);
            ArrayList<BookModule> books=student.getBorrowedBooks();
            if(books.size()==0){
                System.out.println("Student doesnt has any borrowed books");                
            }
            else
            {
                System.out.println("Below are the books borrowed by the student");
                for(int i=0;i<books.size();i++)
                    System.out.println(books.get(i));
            }
        }
    }
}
