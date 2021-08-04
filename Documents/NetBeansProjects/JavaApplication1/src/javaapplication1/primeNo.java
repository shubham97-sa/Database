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
public class primeNo {
      public static void main(String args[])throws IOException{
     BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter any number?");
        int n=Integer.parseInt(br.readLine());
        int temp=0;
        for(int i=2;i<n;i++){
            if(n%i==0){
                temp=temp+1;
                
            }
        }
        if(temp==0){
            System.out.println("This is prime number");
        }else{
            System.out.println("This is not a prime number");
        }
      }
    
    
}
