
package Modules;
import java.util.Date;


public class BookModule {
    private int id;
    private String bookName;
    private String author;
    private String subject;
    private int copies;
    private Date publishDate;
    
    public BookModule(int id, String bookName,String author, String subject,int copies,Date publishDate){
        this.id=id;
        this.bookName=bookName;
        this.author=author;
        this.subject=subject;
        this.copies=copies;
        this.publishDate=publishDate;
                
        
    }
    @Override
     public String toString(){
        String ret="Id: "+id+", Name:"+bookName+", Author:"+author+", subject: "+subject+", Copies: "+copies+",Publish Date: "+publishDate;
        return ret;
    }
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookName;
    }

    public void setBookname(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
