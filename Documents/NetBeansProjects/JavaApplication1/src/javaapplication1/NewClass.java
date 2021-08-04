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
public class NewClass {
    public static void main(String args[])throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter any number?");
        int n=Integer.parseInt(br.readLine());
        if(n>0){
            System.out.println("It is positive number");
        }
        else {
            System.out.println("It is a negative number");
        }
        
    }
    
}
