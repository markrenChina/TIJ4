package ex;

import java.util.Arrays;

public class Ex7 {
    static BerylliumSphere[][][] make(int oneSize,int twoSize,int threeSize){
        BerylliumSphere[][][] res = new BerylliumSphere[oneSize][][];
        for (int i = 0; i < res.length; i++) {
            res[i] = new BerylliumSphere[twoSize][];
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = new BerylliumSphere[threeSize];
                for (int k = 0; k < threeSize; k++) {
                    res[i][j][k] = new BerylliumSphere();
                }
            }
        }
        return res;
    }

    static <T> void printArrayDouble(T[][][] array){
        System.out.println(Arrays.deepToString(array));
    }

    public static void main(String[] args) {
        BerylliumSphere[][][] a = make(2,5,3);
        printArrayDouble(a);
    }
}
