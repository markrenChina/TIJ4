package arrays;

import java.util.Arrays;

public class StringSorting {

    public static void main(String[] args) {
        String[] sa = Generated.array(new String[20],
                new RandomGenerator.String(5));
        System.out.println("Before sort: " + Arrays.toString(sa));
        Arrays.sort(sa);
        System.out.println("after sort: " + Arrays.toString(sa));
        //...
    }
}
