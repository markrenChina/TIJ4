package ex7;

import strings.Splitting;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex7 {

    static String s = Splitting.knights;
    static String s1 = "String.";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[A-Z].*\\.$");
        Matcher matcher = pattern.matcher(s1);
        System.out.println(matcher.matches());
    }
}
