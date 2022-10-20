package arrays;

import java.util.Arrays;
import java.util.Collections;

public class Reverse {
    public static void main(String[] args) {
        CompType[] a = Generated.array(
                new CompType[12],CompType.generator()
        );
        System.out.print("before sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        System.out.print("after sorting:");
        System.out.println(Arrays.toString(a));
    }
}
