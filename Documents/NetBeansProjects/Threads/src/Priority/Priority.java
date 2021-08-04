/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Priority;

/**
 *
 * @author SARBANI
 */
public class Priority  extends Thread {
    public void run(){
        System.out.println("Child Thread");
        
    }
    
} 

class  MainPriority{
    public static void main(String args[]){
        System.out.println(Thread.currentThread().getPriority());
        Priority p =new Priority();
        p.start();
    }
}
