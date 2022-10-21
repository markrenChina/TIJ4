package ex;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Ex23 {

    public static void main(String[] args) {
        Integer[] sa = Generated.array(new Integer[30], new CountingGenerator.Integer());
        Arrays.sort(sa, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Objects.equals(o1, o2) ? 0 : (o1> o2 ? -1 : 1);
            }
        });
        System.out.println(Arrays.toString(sa));
    }
}
