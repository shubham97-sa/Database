
package Details;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class ReturnBook {
    public  void returnBook(Database.Database database) {
        System.out.println("You have chosen to return a book.");
        System.out.println("Enter id of book and student roll num to return");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter book id: ");
        int bookid = Integer.parseInt(input.nextLine());
        System.out.print("Enter roll number: ");
        String rollno = input.nextLine();
        Database.GetBorrowedBook borrowedBook=new Database.GetBorrowedBook();
        int borrowid = borrowedBook.getBorrowedBook(database,bookid, rollno);
        if (borrowid == -1) {
            System.out.println("There is no borrowed book with above details");
        } else {
            System.out.print("Enter return date (YYYY-MM-DD): ");
            String dateString = input.nextLine();
            SimpleDateFormat sourceDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date returndate = null;
            try {
                returndate = sourceDateFormat.parse(dateString);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            Database.ReturnBook returnBook=new Database.ReturnBook();                    
            boolean result = returnBook.returnBook(database,borrowid, returndate);
            if (result) {
                System.out.println("Book returned successfully");
            } else {
                System.out.println("Unable to return book ");
            }
        }
    }
}
