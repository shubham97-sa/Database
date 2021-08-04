/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleepDemo;

/**
 *
 * @author SARBANI
 */
public class sleepDemo extends Thread {
    public void run(){
        for(int i=1;i<=5;i++){
                        
                    
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println(i);
                    
        }
   
            
            
        }
        
    }
    
    

class sleep{
    public static void main (String args[]){
    sleepDemo sd=new sleepDemo();
    sd.start();
}
}