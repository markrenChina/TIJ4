package process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex22 {
    public static List<String> command(String command) {
        boolean err = false;
        List<String> list = new ArrayList<String>();
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader results = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String s;
            while ((s = results.readLine()) != null) {
                list.add(s + "\n");
            }
            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream())
            );
            //report errors and return nonzero value
            //to calling process if there are problems
            while ((s = errors.readLine()) != null) {
                list.add(s + " \n");
                err = true;
            }
        } catch (IOException e) {
            //Compensate for windows 2000,which throws an
            //exception for the default command line
            if (!command.startsWith("CMD /C"))
                command("CMD /C" + command);
            else
                throw new RuntimeException(e);
        }
        if (err)
            throw new OSExecuteException("Errors executing "+command);
        return list;
    }
}
