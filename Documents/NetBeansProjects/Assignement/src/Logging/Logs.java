
package Logging;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


 public  class Logs {
        private static final String File_Path="C:\\Users\\Public\\Documents\\log file";

        static{
            PatternLayout pattern_layout=new PatternLayout();
            String conversionPattern="%-7p %d [%t] %c %x - %m%n";
            pattern_layout.setConversionPattern(conversionPattern);
            FileAppender file_appender= new FileAppender();
            file_appender.setFile(File_Path+ "Error_log.log");
            file_appender.setLayout(pattern_layout);
            file_appender.activateOptions();
            
            Logger logging=Logger.getRootLogger();
            logging.setLevel(Level.DEBUG);
            logging.addAppender(file_appender);
        }
        public static void print_logs(String msg){
            Logger logging1=Logger.getLogger(Logs.class);
            logging1.error(msg);
        }
    }
    

