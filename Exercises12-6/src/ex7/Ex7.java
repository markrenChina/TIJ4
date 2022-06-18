package ex7;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class Ex7 {

    private static Logger logger = Logger.getLogger("Ex7");

    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        int[] foo = new int[0];
        try {
            int i = foo[1];
        }catch (Exception e){
            logException(e);
        }
    }
}
