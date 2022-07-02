package ex18;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex18 {
    public static void main(String[] args) throws Exception {
        if(args.length < 1) {
            System.out.println("Usage: fileName");
            System.exit(0);
        }
        Pattern p = Pattern.compile("\\w+");
        // Iterate through the lines of the input file:
        Matcher m = p.matcher(""); // creates emtpy Matcher object
        System.out.println(args[0] + " comments: ");
        for(String line : new TextFile(args[0])) {
            m.reset(line);
            while(m.find()){
                //for (int i = 0; i < m.groupCount(); i++) {
                System.out.print(m.group(0) + " ");
                //}
            }
            System.out.println();
        }
    }

}
