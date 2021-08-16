
package Details;

import Modules.BookModule;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class UpdateBook {
    public  void editBook(Database.Database database) {
        System.out.println("You have chosen to edit a book.");
        System.out.println("Enter id of book to edit");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter book id: ");
        int bookid = Integer.parseInt(input.nextLine());
        Database.GetBook getBook=new Database.GetBook();
        BookModule book = getBook.getBookById(database,bookid);
        if (book == null) {
            System.out.println("There is no book with above details");
        } else {
            System.out.println("Found book with below details:");
            System.out.println(book);
            System.out.println("Please enter new fields for the book to be updated");
            System.out.print("Enter book's new name: ");
            String bookname = input.nextLine();
            System.out.print("Enter book's new author: ");
            String author = input.nextLine();
            System.out.print("Enter book's newsubject: ");
            String subject = input.nextLine();
            System.out.print("Enter book's new number of copies: ");
            int copies = Integer.parseInt(input.nextLine());
            System.out.print("Enter book's new published date (YYYY-MM-DD): ");
            String dateString = input.nextLine();
            SimpleDateFormat sourceDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date publisheddate = null;
            try {
                publisheddate = sourceDateFormat.parse(dateString);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            Database.UpdateBook updateBook=new Database.UpdateBook();
            boolean result = updateBook.updateBook(database,book.getId(), bookname, author, subject, copies, publisheddate);
            if (result) {
                System.out.println("Book updated successfully");
            } else {
                System.out.println("Unable to update book ");
            }
        }
    }
}
