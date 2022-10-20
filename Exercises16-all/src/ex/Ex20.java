package ex;

import java.util.Arrays;

public class Ex20 {
    public static void main(String[] args) {
        int[][] a = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                a[i][j] = i * j;
            }
        }
        int[][] b = new int[10][10];
//        for (int i = 0; i < 10; i++) {
//            System.arraycopy(a[i],0,b[i],0,10);
//        }
        System.arraycopy(a,0,b,0,10);
        System.out.println(Arrays.deepEquals(a,b));
    }
}
