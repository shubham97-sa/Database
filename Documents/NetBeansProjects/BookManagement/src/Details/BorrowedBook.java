
package Details;

import Modules.StudentModule;
import Modules.BookModule;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class BorrowedBook {
    public  void borrowBook(Database.Database database) {
        System.out.println("You have chosen to borrow a book.");
        System.out.println("Enter id of book and roll number of student to borrow");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter book id: ");
        int bookid = Integer.parseInt(input.nextLine());
        System.out.print("Enter roll number: ");
        String rollno = input.nextLine();
        Database.GetBook getBook=new Database.GetBook();
        BookModule book = getBook.getBookById(database,bookid);
        if (book == null) {
            System.out.println("There is no book with above details");
        } else {
            Database.GetStudent getStudent=new Database.GetStudent();
            StudentModule student = getStudent.getStudent(database,rollno);
            if (student == null) {
                System.out.println("There is no student with above details");
            } else if (student.getBorrowedBooks().size() >= 5) {
                System.out.println("Student already has 5 borrowed books and cannot borrow more!");
            } else {
                System.out.print("Enter borrow date (YYYY-MM-DD): ");
                String dateString = input.nextLine();
                SimpleDateFormat sourceDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date borrowdate = null;
                try {
                    borrowdate = sourceDateFormat.parse(dateString);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                Database.BorrowBook borrowBook=new Database.BorrowBook();
                boolean result = borrowBook.borrowBook(database,book, student, borrowdate);

                if (result) {
                    System.out.println("Book borrowed successfully");
                } else {
                    System.out.println("Unable to borrowed book");
                }
            }
        }
    }
}
