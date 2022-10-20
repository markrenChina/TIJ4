package ex;

import java.util.Arrays;
import java.util.Comparator;

public class Ex21 {
    public static void main(String[] args) {
        BerylliumSphere[] berylliumSpheres1 = new BerylliumSphere[10];
        for (int i = 0; i < 10; i++) {
            berylliumSpheres1[i] = new BerylliumSphere();
        }
        BerylliumSphere[] berylliumSpheres2 = new BerylliumSphere[10];
        System.arraycopy(berylliumSpheres1,0,berylliumSpheres2,0,10);
        System.out.println(Arrays.toString(berylliumSpheres1));
        Arrays.sort(berylliumSpheres1, new Comparator<BerylliumSphere>() {
            @Override
            public int compare(BerylliumSphere o1, BerylliumSphere o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });
        System.out.println(Arrays.toString(berylliumSpheres1));
        System.out.println(Arrays.toString(berylliumSpheres2));
    }
}
