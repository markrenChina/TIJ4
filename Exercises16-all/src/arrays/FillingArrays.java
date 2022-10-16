package arrays;

import java.util.Arrays;

public class FillingArrays {

    public static void main(String[] args) {
        int size = 6;
        boolean[] a1 = new boolean[size];
        byte[] a2 = new byte[size];
        char[] a3 = new char[size];
        //...
        Arrays.fill(a1,true);
        Arrays.fill(a2,(byte)11);
        Arrays.fill(a3,'x');
        //a1 = [true, true, true, true, true, true]
        System.out.println("a1 = " + Arrays.toString(a1));
        //a2 = [11, 11, 11, 11, 11, 11]
        System.out.println("a2 = " + Arrays.toString(a2));
        //a3 = [x, x, x, x, x, x]
        System.out.println("a3 = " + Arrays.toString(a3));

        String[] a9 = new String[size];
        Arrays.fill(a9,"Hello");
        //[Hello, Hello, Hello, Hello, Hello, Hello]
        System.out.println("a9 = " + Arrays.toString(a9));
        //[Hello, Hello, Hello, world, world, Hello]
        Arrays.fill(a9,3,5,"world");
        System.out.println("a9 = " + Arrays.toString(a9));

    }
}
