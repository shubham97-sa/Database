
package common.services;
import common.services.Parsing;
import common.module.ProfitRecord;
import common.logs.logs;
import java.io.*;
import java.util.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReadFile {

    static List<ProfitRecord> list = new ArrayList();
    static List<String> erroredList = new ArrayList();

    public static void ReadFile() {
        //Create the pool
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Scanner readFilePath =new Scanner(System.in);
        System.out.println("Enter path of source file ?");
        final String FILE_PATH=readFilePath.next();
        Scanner readFileScanner = null;
        try {
            
            File file = new File(FILE_PATH);
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
                            logs.print_logs("ERROR IN READING FILE - " + str);
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

