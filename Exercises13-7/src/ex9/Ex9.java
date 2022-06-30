package ex9;

import strings.Splitting;

public class Ex9 {
    static String s = Splitting.knights;

    public static void main(String[] args) {
        System.out.println(s.replaceAll("[aeiouAEIOU]","_"));
    }
}
