package ex;

import arrays.RandomGenerator;
import net.mindview.util.Generated;

import java.util.Arrays;

public class Ex22 {

    public static void main(String[] args) {
        String[] sa = Generated.array(new String[30], new RandomGenerator.String(5));
        System.out.println(Arrays.toString(sa));
        int index = Arrays.binarySearch(sa,sa[10],String.CASE_INSENSITIVE_ORDER);
        System.out.println("Index: "+ index + "\n" + sa[index]);
    }
}
