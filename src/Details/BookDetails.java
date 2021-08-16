

package Details;

import  Database.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookDetails {
    public  void addBook(Database database) {
        System.out.println("You have chosen to add a book.");
        System.out.println("Please enter below fields for the new book to be added");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter book name: ");
        String bookname = input.nextLine();
        System.out.print("Enter author: ");
        String author = input.nextLine();
        System.out.print("Enter subject: ");
        String subject = input.nextLine();
        System.out.print("Enter number of copies: ");
        int copies = Integer.parseInt(input.nextLine());
        System.out.print("Enter published date (YYYY-MM-DD): ");
        String dateString = input.nextLine();
        SimpleDateFormat sourceDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date publisheddate = null;
        try {
            publisheddate = sourceDateFormat.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        AddBook addBook=new AddBook();
        boolean result = addBook.addBookToDatabase(database,bookname, author, subject, copies, publisheddate);
        if (result) {
            System.out.println("Book added successfully");
        } else {
            System.out.println("Unable to add book ");
        }
    }
}
