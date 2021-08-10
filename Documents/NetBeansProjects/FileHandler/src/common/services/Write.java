
package common.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import common.services.ReadFile;
import common.module.ProfitRecord;
import common.logs.logs;
import java.util.Scanner;


public class Write {
    String writeFile;
    String errorData;

    private final String HEADER = "Year,Country,State,City,Item,Profit(in USD)\n";
    Scanner destinationPath=new Scanner(System.in);
    Scanner errorDataPath=new Scanner(System.in);
       

    //@Override
    public void writeValidRecords(List<ProfitRecord> records) {
        try {
             System.out.println("Enter destination path?");
        writeFile=destinationPath.nextLine();
            BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile));
            writer.write(HEADER);
            for (int i = 0; i < records.size(); i++) {
                writer.write(records.get(i).toString()+ "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception exception) {
            logs.print_logs("Error in writing to csv file - " + exception.toString());
        }
    }

    public void writeErroredRecords(List<String> erroredRecords) {
        try {
                System.out.println("Enter path of error file?");
        errorData=destinationPath.nextLine();
            BufferedWriter writer = new BufferedWriter(new FileWriter(errorData));
            for (int i = 0; i < erroredRecords.size(); i++) {
                writer.write(erroredRecords.get(i)+ "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception exception) {
            logs.print_logs("Error in writing to error records file - " + exception.toString());
        }
    }
}

