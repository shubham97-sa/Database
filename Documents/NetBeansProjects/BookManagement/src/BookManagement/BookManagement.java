
package BookManagement;
import Database.*;
import Details.*;
import DisplayMenu.*;

import java.util.Scanner;


public class BookManagement {

    public static Database database;

    public static void main(String args[]) {
        database = new Database();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("############ Welcome to book management system ############");
        while (true) {
            DisplayMenu displayMenu= new DisplayMenu();
            displayMenu.displayMenu();
            System.out.print("Press enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 1) {
                BookDetails bookDetails=new BookDetails();
                bookDetails.addBook(database);
            } else if (choice == 2) {
                StudentDetails studentDetails= new StudentDetails();
                studentDetails.addStudent(database);
            } else if (choice == 3) {
                BorrowedBook borrowedBook=new BorrowedBook();
                borrowedBook.borrowBook(database);
            } else if (choice == 4) {
                FifteenDaysComp fifteenDaysCop = new FifteenDaysComp();
                fifteenDaysCop.printMoreThan15Days(database);
            } else if (choice == 5) {
                SearchStudent searchStudent=new SearchStudent();
                searchStudent.searchStudent(database);
            } else if (choice == 6) {
                Details.DeleteBook deleteBook=new Details.DeleteBook();
                deleteBook.deleteBook(database);
            } else if (choice == 7) {
                Details.UpdateBook updateBook=new Details.UpdateBook();
                updateBook.editBook(database);
            } else if (choice == 8) {
                Details.ReturnBook returnBook=new Details.ReturnBook();                
                returnBook.returnBook(database);
            } else if (choice == 9) {
                System.out.println("Exiting Book Management System! Thank You L&G!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}