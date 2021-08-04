/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author SARBANI
 */

//
//public class Threads extends Thread{
//    public void run(){
//        for(int i=1;i<1000;i++){
//            System.out.println(i);
//        }
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//   
//    
//}
// class CreateThread{
//    public static void main (String args[]){
//        Threads myThread=new Threads();
//        
//        myThread.start();
//        
//      
//        
//        
//    }
//}

public class Threads extends Thread{
    public void run(){
        for(int number=2;number<439;number++){
            System.out.println(number);
        }
    }
    
}
 class CreateThread{
    public static void main (String args[]){
        Threads thread=new Threads();
       
        thread.start();
        Threads thread2=new Threads();
        thread2.start();
    }
}