package ex13;

import strings.Groups;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartEnd {

    static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find()){
            d.display("find() '" +m.group() + "' start = "+m.start() + " end = " + m.end());
        }
        if (m.lookingAt()) {
            //No reset() necessary
            d.display("lookingAt() start = "+m.start() +" end = " + m.end());
        }
        if (m.matches()) {
            //No reset() necessary
            d.display("matches() start = " + m.start() + " end = " + m.end());
        }
    }

    public static void main(String[] args) {
        for(String in : Groups.POEM.split("\n")) {
            System.out.println("input: " + in);
            for (String regex : new String[] {
                    "\\w*ere\\w*","\\w*ever","T\\w+","Never.*?!"
            }){
                examine(in,regex);
            }
        }
    }

    private static class Display {
        private boolean regexPrinted = false;
        private String regex;
        Display(String regex) {
            this.regex = regex;
        }

        void display(String message) {
            if (!regexPrinted) {
                System.out.println(regex);
                regexPrinted = true;
            }
            System.out.println(message);
        }
    }
}
