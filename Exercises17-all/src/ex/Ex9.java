package ex;

import net.mindview.util.RandomGenerator;

import java.util.TreeSet;

public class Ex9 {

    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        RandomGenerator.String string = new RandomGenerator.String();
        for (int i = 0; i < 26; i++) {
            ts.add(string.next());
        }
        System.out.println(ts);
    }
}
