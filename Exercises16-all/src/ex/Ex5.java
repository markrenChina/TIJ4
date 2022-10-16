package ex;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Ex5 {
    static Double[][][] make(int minSize,int maxSize){
        Random random = ThreadLocalRandom.current();
        Double[][][] res =
                new Double[random.nextInt(maxSize-minSize)+minSize][][];
        for (int i = 0; i < res.length; i++) {
            res[i] = new Double[random.nextInt(maxSize-minSize)+minSize][];
            for (int i1 = 0; i1 < res[i].length; i1++) {
                res[i][i1] = new Double[random.nextInt(maxSize-minSize)+minSize];
            }
        }
        return res;
    }

    static void printArrayDouble(Double[][][] array){
        System.out.println(Arrays.deepToString(array));
    }

    public static void main(String[] args) {
        Double[][][] a = make(1,5);
        printArrayDouble(a);
    }
}
