package ex2;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }

    @Override
    public String toString() {
        //System.out.println(super.toString());
        return " InfiniteRecursion address ： " + Integer.toHexString(System.identityHashCode(this)) + "\n";
    }
}
