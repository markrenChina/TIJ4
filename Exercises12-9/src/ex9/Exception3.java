package ex9;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class Exception3 extends Exception{
    private static Logger logger = Logger.getLogger("Exception2");

    public Exception3() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
