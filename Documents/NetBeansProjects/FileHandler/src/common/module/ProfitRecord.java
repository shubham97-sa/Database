
package common.module;

public class ProfitRecord implements Comparable<ProfitRecord> {

    private final int  year;
    private String country;
    private String state;
    private String city;
    private String item;
    private double profitUSD;

    public ProfitRecord(int year, String country, String state, String city, String item, double profitUSD) {
        this.year = year;
        this.country = country;
        this.state = state;
        this.city = city;
        this.item = item;
        this.profitUSD = profitUSD;
    }

    @Override
    public String toString() {
        return year + "," + country + "," + state + "," + city + "," + item + "," + Math.round(profitUSD);
    }

    @Override
    public int compareTo(ProfitRecord ProfitRecordObj2) {
        if (year > ProfitRecordObj2.year) {
            return 1;
        } else if (year < ProfitRecordObj2.year) {
            return -1;
        } else {
            if (!country.equals(ProfitRecordObj2.country)) {
                return country.compareTo(ProfitRecordObj2.country);
            } else {
                if (profitUSD > ProfitRecordObj2.profitUSD) {
                    return 1;
                } else if (profitUSD < ProfitRecordObj2.profitUSD) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }
}
