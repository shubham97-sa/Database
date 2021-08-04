/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Naming;

/**
 *
 * @author SARBANI
 */
//public class NamingThread {
//    public static void main(String args[]){
////        System.out.println(Thread.currentThread().getName());
//        Thread.currentThread().setName("Shubham");
//        System.out.println(Thread.currentThread().getName());
//    }
//}
public class NamingThread extends Thread{

    public void run(){
        System.out.println("First thread");
        System.out.println(Thread.currentThread().getName());
        
    }
}
class thread{
    public static void main (String args[]){
        System.out.println("main thread");
        NamingThread t=new NamingThread();
         t.setDaemon(true);
        t.start();
       

    }
}
