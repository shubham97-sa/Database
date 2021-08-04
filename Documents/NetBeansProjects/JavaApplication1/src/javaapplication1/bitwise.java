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
public class bitwise {
    public static void main (String args[])throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter first number?");
        int n=Integer.parseInt(br.readLine());
        System.out.println("Enter second number?");
        int x=Integer.parseInt(br.readLine());
        
        System.out.println("Bitwise AND operator =" + (n & x));
        System.out.println("Bitwise OR operator =" + (n | x));
        System.out.println("Bitwise Right shift operator=" + (n>>2));
        System.out.println("Bitwise Left shift operator=" + (n<<2));
        
        
        
        
    }
    
}
