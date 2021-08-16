
package Details;
import Modules.StudentModule;

import  Database.*;
import java.util.ArrayList;

public class FifteenDaysComp {
    public static void printMoreThan15Days(Database database) {
        System.out.println("You have chosen to list students having book for more than 15 days");
        MoreThan15Days moreThan15Days=new MoreThan15Days();
        ArrayList<StudentModule> students = moreThan15Days.getMoreThan15DaysList(database);
        if (students.size() == 0) {
            System.out.println("There are no students having book for more than 15 days");
        } else {
            System.out.println("Below are the students having book for more than 15 days");
            for(int i=0;i<students.size();i++)
                System.out.println(students.get(i));
        }
    }
}
