package Ex16;

import net.mindview.util.TextFile;

import java.io.File;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex16 {
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

    private static void grepFile(File file,Matcher m,int index){
        for (String line : new TextFile(file.getAbsolutePath())) {
            m.reset(line);
            while (m.find()){
                System.out.println(index++ +": " + m.group() + ": "+m.start());
            }
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
        File root = new File(args[0]);
        if (root.isDirectory()){
            for (File f: Objects.requireNonNull(root.listFiles())){
                grepFile(f,m,index);
            }
        }else {
            grepFile(root,m,index);
        }
    }
}
