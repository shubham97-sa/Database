
package Details;


import  Database.*;
import java.util.Scanner;
public class StudentDetails {
    public  void addStudent(Database database) {
        System.out.println("You have chosen to add a student.");
        System.out.println("Please enter below fields for the new student to be added");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter roll number: ");
        String rollNo = input.nextLine();
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter email: ");
        String email = input.nextLine();
        System.out.print("Enter class: ");
        String className = input.nextLine();
        System.out.print("Enter mobile: ");
        String mobileNo = input.nextLine();
        AddStudent addStudent=new AddStudent();
        boolean result = addStudent.addStudentToDatabase(database,rollNo, name, email, className, mobileNo);
        if (result) {
            System.out.println("Student added successfully");
        } else {
            System.out.println("Unable to add student");
        }
    }

}

