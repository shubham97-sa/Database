
package Modules;

import java.util.ArrayList;



public class StudentModule {
    private int id;
    private String rollNo;
    private String name;
    private String email;
    private String className;
    private String mobileNo; 
    private ArrayList<BookModule> borrowedBooks; 
    public StudentModule(int id, String rollNo, String name, String email, String className, String mobileNo) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.className = className;
        this.mobileNo = mobileNo;
        this.borrowedBooks=new ArrayList<BookModule>();
    }
    public String toString(){
        String ret="Id: "+id+", Roll No:"+rollNo+", Name:"+name+", Email: "+email+", Class: "+className+",Mobile: "+mobileNo;
        return ret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public ArrayList<BookModule> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<BookModule> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
    
    
}
