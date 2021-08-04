/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Join;

/**
 *
 * @author SARBANI
 */

class Medical extends Thread{
    public void run(){
        try{
            System.out.println("Medical Started");
            Thread.sleep(3000);
            System.out.println("Medical completed");
            
        }catch(Exception e){
            System.out.println(e);
            
        }
        
    
}
}

class TestDriver extends Thread{
    public void run(){
        try{
            System.out.println("Test Driving Started");
            Thread.sleep(3000);
            System.out.println("Test Driving Completed");
            
        }catch(Exception e){
            System.out.println(e);
            
        }
        
    
}
}
class OfficerSign extends Thread{
    public void run(){
        try{
            System.out.println("Officer seeing file");
            Thread.sleep(3000);
            System.out.println("Officer completed the file");
            
        }catch(Exception e){
            System.out.println(e);
            
        }
        
    
}
}
public class LicenseDemo {
    public static void main(String args[]) throws InterruptedException{
        Medical md=new Medical();
        md.start();
        md.join();
        
        TestDriver td= new TestDriver();
        td.start();
        td.join();
        
        OfficerSign os= new OfficerSign();
        os.start();
    }
    
}
