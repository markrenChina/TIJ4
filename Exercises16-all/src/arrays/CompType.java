package arrays;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.util.Arrays;
import java.util.Random;

public class CompType implements Comparable<CompType>{
    public static Random r = new Random(47);
    private static int count = 1;
    int i;
    int j;

    public CompType(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static Generator<CompType> generator() {
        return new Generator<CompType>() {
            @Override
            public CompType next() {
                return new CompType(r.nextInt(100),r.nextInt(100));
            }
        };
    }

    public static void main(String[] args) {
        CompType[] a = Generated.array(new CompType[12],generator());
        System.out.print("before sorting:");
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.print("after sorting:");
        System.out.println(Arrays.toString(a));

    }

    @Override
    public String toString() {
        String result =  "[i = " + i + ", j = " + j + "]";
        if (count++ % 3  == 0) {
            result += "\n";
        }
        return result;
    }

    @Override
    public int compareTo(CompType rv) {
        return Integer.compare(i, rv.i);
    }
}
