/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignement;
import java.io.*;  

import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.FileWriter;
import com.opencsv.CSVWriter;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.apache.log4j.FileAppender;

import org.apache.log4j.PatternLayout;

import org.apache.log4j.Logger;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Level;



/**
 *
 * @author SARBANI
 */
public class Assignement {
    static  List<String[]> list= new ArrayList();

    
    public static void ReadFile() {
        
        
        Scanner sc=null;
       
        try{
            File file=new File("C:\\Users\\Public\\Documents\\data.txt");
            sc=new Scanner(file);
            while(sc.hasNextLine()){
                String str=sc.nextLine();
               
                parseLine(str);
            } 
            if(!list.isEmpty()){
                try(CSVWriter writer=new  CSVWriter(new FileWriter("D:\\new.csv"))){
                    writer.writeAll(list);
                }
           
           
            }
        }catch(IOException e){
            System.out.println("There is an error while reading file " + e.getMessage());
                    
                    }
        finally{
            if(sc!=null){
                sc.close();
            }
        }
    }
   
 


    public static boolean parseLine(String str) throws SecurityException,IOException {
//        final Logger logger=Logger.getLogger(Assignement.class.getName());
//        FileHandler file_handler=null;
//        
        
        SimpleDateFormat format=new SimpleDateFormat("M-d_HHmmss");
        boolean result=false;
        if(str.matches("^[0-9a-zA-Z|]+$")){
        
        
        String arr[]=str.split("\\|");
        if(arr.length==6){
           
            
            
//            System.out.println(Arrays.toString(arr));
         System.out.println("Year- " + arr[year_profit.year] + " Country- " + arr[year_profit.country].toUpperCase() + " State- " + arr[year_profit.state] + " City- " + arr[year_profit.city] + " Item- " + arr[year_profit.item] + " Profit-" + "$"+ Math.round(Double.parseDouble(arr[year_profit.profit])/74.38));
        list.add(arr);
        
        
        }
        else if(arr.length!=6){
            Logs.print_logs("Please enter valid record");
            return false;
            
            
        }
        else if(!arr[5].matches("\\d")){
            Logs.print_logs("Year is invalid");
            return false;
            
        }
        else{
            Logs.print_logs("DELIMITER IS INVALID");
        }
        
//        else {
//            file_handler=new FileHandler("C:\\Users\\Public\\Documents\\log file"+ format.format(Calendar.getInstance().getTime())+ ".log");
//            SimpleFormatter formatter= new SimpleFormatter();
//                        file_handler.setFormatter(new SimpleFormatter());
//           
//        }
            
        }
        return true;
        
    }

    public  class Logs {
        private static final String File_Path="C:\\Users\\Public\\Documents\\log file";

        static{
            PatternLayout pattern_layout=new PatternLayout();
            String conversionPattern="%-7p %d [%t] %c %x - %m%n";
            pattern_layout.setConversionPattern(conversionPattern);
            FileAppender file_appender= new FileAppender();
            file_appender.setFile(File_Path+ "Error_log.log");
            file_appender.setLayout(pattern_layout);
            file_appender.activateOptions();
            
            Logger logging=Logger.getRootLogger();
            logging.setLevel(Level.DEBUG);
            logging.addAppender(file_appender);
        }
        public static void print_logs(String msg){
            Logger logging1=Logger.getLogger(Logs.class);
            logging1.error(msg);
        }
    }
}
    

