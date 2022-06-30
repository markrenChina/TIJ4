package ex8;

import strings.Splitting;

import java.util.Arrays;

public class Ex8 {
    static String s = Splitting.knights;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(s.split("the|you")));
    }
}
