package ex;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Ex4 {
    static double[][][] make(int minSize,int maxSize){
        Random random = ThreadLocalRandom.current();
        double[][][] res =
                new double[random.nextInt(maxSize-minSize)+minSize][][];
        for (int i = 0; i < res.length; i++) {
            res[i] = new double[random.nextInt(maxSize-minSize)+minSize][];
            for (int i1 = 0; i1 < res[i].length; i1++) {
                res[i][i1] = new double[random.nextInt(maxSize-minSize)+minSize];
            }
        }
        return res;
    }

    static void printArrayDouble(double[][][] array){
        System.out.println(Arrays.deepToString(array));
    }

    public static void main(String[] args) {
        double[][][] a = make(1,5);
        printArrayDouble(a);
    }
}
