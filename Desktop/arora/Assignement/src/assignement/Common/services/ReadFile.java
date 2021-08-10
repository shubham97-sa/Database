/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignement.Common.services;

import assignement.Common.services.Write;
import common.logs.Logs;
import common.module.ProfitRecord;
import common.main.year_profit;
import java.io.*;

import java.util.*;
import java.util.Scanner;
import java.util.logging.*;
import java.io.FileWriter;
import com.opencsv.CSVWriter;

import java.text.SimpleDateFormat;
import java.util.concurrent.*;
import org.apache.log4j.*;


public class ReadFile {

    static List<ProfitRecord> list = new ArrayList();
    static List<String> erroredList = new ArrayList();

    public static void ReadFile() {
        //Create the pool
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Scanner readFileScanner = null;
        try {
            File file = new File("data.txt");
           readFileScanner= new Scanner(file);
//            int count1=0,count2=0;
            Future future=null;
            while (readFileScanner.hasNextLine()) {
//                count1++;
                String str = readFileScanner.nextLine();
                 future = executor.submit(new Runnable() {
                    public void run() {
                        try {
                            
                            Parsing.parseLine(str);
                        } catch (Exception ex) {
                            Logs.print_logs("ERROR IN READING FILE - " + str);
                        }
                    }
                });
            }
            while(future.get()!=null) continue;
            executor.shutdown();           
            if (!list.isEmpty()) {
                Collections.sort(list);
                Write csvWrite = new Write();
                csvWrite.writeValidRecords(list);
            }
            if (!erroredList.isEmpty()) {
                Write errorDataobj = new Write();
                errorDataobj.writeErroredRecords(erroredList);
            }

        } catch (Exception e) {
            System.out.println("There is an error while reading file " + e.getMessage());

        } finally {
            if (readFileScanner != null) {
                readFileScanner.close();
                
            }
        }
    }
}
