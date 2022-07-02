package ex14;

import java.util.Arrays;

public class Ex14 {

    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(input.split("!!")));
        //Only do the first three
        //System.out.println(Arrays.toString(Pattern.compile("!!").split(input,3)));
    }
}
