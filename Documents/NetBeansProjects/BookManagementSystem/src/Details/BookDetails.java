package Details;
import bookmanagementsystem.BookManagementSystem;
import DatabaseConnection.DatabaseConnection;
import java.util.*;
import java.sql.*;




public class BookDetails {
    public String bookName;
    public String author;
    public String subject;
    public int noOfCopies;
    public String publishDate;
    
    public void getBookDetails() {
        try{
        Scanner input =new Scanner(System.in);   
        System.out.println("Please Enter book name");
        bookName=input.nextLine();
        System.out.println("Please enter author name");
        author=input.nextLine();
        System.out.println("Please enter subject");
        subject=input.nextLine();
        System.out.println("Please enter no of copies");
        noOfCopies=input.nextInt();
        System.out.println("Please enter publish date");
       publishDate=input.nextLine();
        }catch(Exception e){
            System.out.println(e);  
        }
        
    }
    public void insertBookDetails() 
    {
        try{
              DatabaseConnection dbc=new DatabaseConnection("jdbc:postgresql://localhost:5432/bookmanagement", "postgres","17241231");
              Connection con=dbc.getConnection();
        
        String sql = "INSERT INTO bookDetails values (?,?,?,?,?);";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,bookName);
        pstmt.setString(2,author);
        pstmt.setString(3,subject);
        pstmt.setInt(4,noOfCopies);
        pstmt.setString(5,publishDate);
        pstmt.execute();
        System.out.println("Records added successfully");
        pstmt.close();
        con.close();       
        }catch(Exception e){
            System.out.println(e);
            
        }
        
        
    }
    
}
