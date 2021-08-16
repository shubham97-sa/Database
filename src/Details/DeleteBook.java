package Details;
import Modules.BookModule;



import java.util.Scanner;

public class DeleteBook {
    public  void deleteBook(Database.Database database) {
        System.out.println("You have chosen to delete a book.");
        System.out.println("Enter name and author of book to delete");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter book name: ");
        String bookname = input.nextLine();
        System.out.print("Enter author name: ");
        String author = input.nextLine();
        Database.GetBook getBook=new Database.GetBook();
        BookModule book = getBook.getBook(database,bookname, author);
        if (book == null) {
            System.out.println("There is no book with above details");
        } else {
            System.out.println("Found book with below details:");
            System.out.println(book);
            Database.DeleteBook deleteBook=new Database.DeleteBook();
            boolean result = deleteBook.deleteBook(database,book.getId());
            if (result) {
                System.out.println("Book deleted successfully");
            } else {
                System.out.println("Unable to delete book ");
            }
        }
    }
}



