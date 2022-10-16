package ex;

import java.util.Arrays;

public class Ex2 {
    public static BerylliumSphere[] make(int size){
        BerylliumSphere[] res = new BerylliumSphere[size];
        for (int i = 0; i < size; i++) {
            if (res[i] == null){
                res[i] = new BerylliumSphere();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BerylliumSphere[] a= make(5);
        System.out.println(Arrays.toString(a));
    }
}
