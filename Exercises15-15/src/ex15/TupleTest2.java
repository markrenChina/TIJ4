package ex15;

import net.mindview.util.TwoTuple;

import static net.mindview.util.Tuple.tuple;

public class TupleTest2 {
    static TwoTuple<String,Integer> f() {
        return tuple("hi",47);
    }
    static TwoTuple f2() { return tuple("hi",47); }

    public static void main(String[] args) {
        TwoTuple<String,Integer> ttsi = f();
        System.out.println(ttsi);
        TwoTuple<Integer,Integer> ttsi2 = f2();
        System.out.println(ttsi2);
    }
}
