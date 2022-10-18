package ex;

import arrays.Generated;
import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BerylliumSphereGenerator implements Generator<BerylliumSphere> {
    public BerylliumSphere next() {
        return new BerylliumSphere();
    }
}

public class Ex15 {
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[5];
        BerylliumSphereGenerator bsg = new BerylliumSphereGenerator();
        Generated.array(spheres, bsg);
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);
        List<BerylliumSphere> sphereList =
                new ArrayList<BerylliumSphere>();
        for(int i = 0; i < 5; i++)
            sphereList.add(bsg.next());
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));
    }
}
