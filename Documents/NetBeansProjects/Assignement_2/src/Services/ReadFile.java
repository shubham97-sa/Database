/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import java.io.*;  
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.apache.log4j.FileAppender;

import org.apache.log4j.PatternLayout;

import org.apache.log4j.Logger;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import org.apache.log4j.Level;



/**
 *
 * @author SARBANI
 */
public class ReadFile {
    static  List<String[]> list= new ArrayList();
   
    public static void ReadFile() {
        Scanner readFilePath =new Scanner(System.in);
        System.out.println("Enter path");
        final String FILE_PATH=readFilePath.next();
        
        Scanner FileReader=null;
       
        try{
            File file=new File(FILE_PATH);
            FileReader=new Scanner(file);
            while(FileReader.hasNextLine()){
                String str=FileReader.nextLine();
                ParseLine.parseLine(str);
                
                     
            }
                  
            if(!list.isEmpty()){
                

Write csvWrite = new Write();
csvWrite.csv(list);
            }
           

        }catch(IOException e){
            System.out.println("There is an error while reading file " + e.getMessage());
                    
                    }
        finally{
            if(FileReader!=null){
                FileReader.close();
            }
        }
        
                               
    }

}
