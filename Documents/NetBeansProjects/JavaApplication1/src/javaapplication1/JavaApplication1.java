/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author SARBANI
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter the number which you want to check it is pallindrome or not?");
       int n=Integer.parseInt(br.readLine());
       int rev=0,z;
       z=n;
       while(n>0){
           rev=(rev*10) + n % 10;
           n=n/10;
       }
       if(rev==z){
           System.out.println("This number is pallindrome");
           
       }else{
           System.out.println("This no is not a pallindrome");
       }
      /*int age= 18;
      int weight = 50;
      if(age>=18){
          if(weight>=50){
          System.out.println("You are eligible to donate blood");
      }else{
              System.out.println("You are not eligible to donate blood");
          }
      }else{
          System.out.println("Your age must be above 18");
      }*/
        // TODO code application logic here
    }
    
}
