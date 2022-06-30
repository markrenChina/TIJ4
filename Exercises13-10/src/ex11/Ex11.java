package ex11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex11 {

    static String str = "Arline ate eight apples and one orange while Anita hadn't any";
    static String regex = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()){
            System.out.println("Match \"" + m.group() +"\" + at positions "
                    + m.start() + "-" + (m.end() - 1));
        }
    }
}
