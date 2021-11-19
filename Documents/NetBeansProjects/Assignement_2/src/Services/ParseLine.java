/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Logging.Logs;
import ReadWrite.year_profit;
import static Services.ReadFile.list;
import java.io.IOException;
import java.text.SimpleDateFormat;


public class ParseLine {
    
    public static boolean parseLine(String str) throws SecurityException,IOException {

        SimpleDateFormat format=new SimpleDateFormat("M-d_HHmmss");
        boolean result=false;
        if(str.matches("^[0-9a-zA-Z|]+$")){   
        String arr[]=str.split("\\|");
        if(arr.length==6){
           
           
         System.out.println("Year- " + arr[year_profit.year] + " Country- " + arr[year_profit.country].toUpperCase() + " State- " + arr[year_profit.state] + " City- " + arr[year_profit.city] + " Item- " + arr[year_profit.item] + " Profit-" + "$"+ Math.round(Double.parseDouble(arr[year_profit.profit])/74.38));
        list.add(arr);
        }
        else if(arr.length!=6){
            Logs.print_logs("Please enter valid record");
            return false;           
        }
        else if(!arr[5].matches("d{4}")){
            Logs.print_logs("Year is invalid");
            return false;            
        }
        else{
            Logs.print_logs("DELIMITER IS INVALID");
        }
            
      }
        return true;
        
    }
    
}
