
package common.services;
import common.logs.logs;
import common.module.ProfitRecord;
import static common.services.ReadFile.erroredList;
import static common.services.ReadFile.list;
import java.util.*;


import java.io.IOException;
import filehandler.year_profit;
import java.text.SimpleDateFormat;
import common.services.Write;

public class Parsing {
       public static boolean parseLine(String str) throws SecurityException, IOException {

        SimpleDateFormat format = new SimpleDateFormat("M-d_HHmmss");
        boolean result = false;
        if (str.matches("^[0-9a-zA-Z|]+$")) {

            String arr[] = str.split("\\|");
            if (arr.length == 6) {
                System.out.println("Year- " + arr[year_profit.year] + " Country- " + arr[year_profit.country].toUpperCase() + " State- " + arr[year_profit.state] + " City- " + arr[year_profit.city] + " Item- " + arr[year_profit.item] + " Profit-" + "$" + Math.round(Double.parseDouble(arr[year_profit.profit]) / 74.38));
                int year = Integer.parseInt(arr[year_profit.year]);
                String country = arr[year_profit.country].toUpperCase();
                String state = arr[year_profit.state];
                String city = arr[year_profit.city];
                String item = arr[year_profit.item];
                double profit = Double.parseDouble(arr[year_profit.profit]) / year_profit.dolllarPrice;
                ProfitRecord records = new ProfitRecord(year, country, state, city, item, profit);
                list.add(records);
                
            } else if (arr.length != 6) {
                logs.print_logs("Please enter valid record (" + str + ")");
                erroredList.add(str);
                return false;

            } else if (!arr[5].matches("\\d")) {
                logs.print_logs("Year is invalid (" + str + ")");
                erroredList.add(str);
                return false;

            }
        } else {
            logs.print_logs("DELIMITER IS INVALID (" + str + ")");
            erroredList.add(str);
            return false;
        }

        return true;

    }
    
}
