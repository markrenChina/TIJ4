package ex15;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Args: JGrep.java "\\b[Ssct]\\w+"
public class Ex15 {
    private static int parseMode(String mode){
        switch (mode){
            case "?i": return Pattern.CASE_INSENSITIVE;
            case "?x": return Pattern.COMMENTS;
            case "?s": return Pattern.DOTALL;
            case "?m": return Pattern.MULTILINE;
            case "?u": return Pattern.UNICODE_CASE;
            case "?d": return Pattern.UNIX_LINES;
            default: throw new RuntimeException("error mode");
        }
    }

    public static void main(String[] args) {
        if (args.length < 2){
            System.out.println("Usage: java Jgrep file regex");
            System.exit(0);
        }
        int flags= 0;
        if (args.length == 3){
            String[] mode = args[2].split("\\|");
            for (String s : mode){
                flags |= parseMode(s);
            }
        }
        Pattern p = Pattern.compile(args[1],flags);
        //Iterate through the liens of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        for (String line : new TextFile(args[0])) {
            m.reset(line);
            while (m.find()){
                System.out.println(index++ +": " + m.group() + ": "+m.start());
            }
        }
    }
}
