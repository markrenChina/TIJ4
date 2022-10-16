package arrays;

import java.util.Arrays;
import java.util.Random;

public class RaggedArray {
    public static void main(String[] args) {
        Random rand = new Random(47);
        //3-D array with varied-length vectors;
        int[][][] a = new int[rand.nextInt(7)][][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[rand.nextInt(5)][];
            for (int i1 = 0; i1 < a[i].length; i1++) {
                a[i][i1] = new int[rand.nextInt(5)];
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
}
