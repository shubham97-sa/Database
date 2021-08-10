
package assignement.Common.services;

import common.logs.Logs;
import common.module.ProfitRecord;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class Write {

    private final String HEADER = "Year,Country,State,City,Item,Profit(in USD)\n";

    //@Override
    public void writeValidRecords(List<ProfitRecord> records) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\hero2.csv"));
            writer.write(HEADER);
            for (int i = 0; i < records.size(); i++) {
                writer.write(records.get(i).toString()+ "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception exception) {
            Logs.print_logs("Error in writing to csv file - " + exception.toString());
        }
    }

    public void writeErroredRecords(List<String> erroredRecords) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\errorData2.txt"));
            for (int i = 0; i < erroredRecords.size(); i++) {
                writer.write(erroredRecords.get(i)+ "\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception exception) {
            Logs.print_logs("Error in writing to error records file - " + exception.toString());
        }
    }
}
