
package Services;
import Logging.Logs;
import Logging.Logs;
import ReadWrite.year_profit;
import Services.ReadFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java .util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Write  {
    String writeFile;
    private final String HEADER="year,Country,State,City,Items,Profit(USD)\n";
    
    
    public void csv(List<String[]> a){
        Scanner destinationPath=new Scanner(System.in);
        System.out.println("Enter destination path");
        writeFile=destinationPath.nextLine();
        
        try{
            BufferedWriter writer= new BufferedWriter(new FileWriter(writeFile));
            writer.write(HEADER);
            for(int i=0;i<a.size();i++){
                String csv_cell[]=(String[])a.get(i);
                String Records=csv_cell[year_profit.year] + "," +csv_cell[year_profit.country].toUpperCase() +"," + csv_cell[year_profit.state] + "," + csv_cell[year_profit.city] + "," + csv_cell[year_profit.item] + "," + Integer.valueOf(csv_cell[year_profit.profit])/year_profit.dolllarPrice+"\n";
                 writer.write(Records);
            }
            writer.flush();
            writer.close();
        }catch(Exception e4){
            Logs.print_logs("Error in csv file" + e4.toString());
        }
        
    }
}
