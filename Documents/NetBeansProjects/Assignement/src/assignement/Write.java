/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignement;
import assignement.Assignement.Logs;
import assignement.Assignement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java .util.ArrayList;
import java.util.List;

/**
 *
 * @author SARBANI
 * 
 * 
 */


public class Write  {
    private final String HEADER="year,Country,State,City,Items,Profit(USD)\n";
    
    //@Override
    
    public void csv(List<String[]> a){
        try{
            BufferedWriter b= new BufferedWriter(new FileWriter("D:\\new2.csv"));
            b.write(HEADER);
            for(int i=0;i<a.size();i++){
                String csv_cell[]=(String[])a.get(i);
                String Records=csv_cell[year_profit.year] + "," +csv_cell[year_profit.country].toUpperCase() +"," + csv_cell[year_profit.state] + "," + csv_cell[year_profit.city] + "," + csv_cell[year_profit.item] + "," + Integer.valueOf(csv_cell[year_profit.profit])/year_profit.dolllarPrice+"\n";
                 b.write(Records);
            }
            b.flush();
            b.close();
        }catch(Exception e4){
            Logs.print_logs("Error in csv file" + e4.toString());
        }
        
    }
}
