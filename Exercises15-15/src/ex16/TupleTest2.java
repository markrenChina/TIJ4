package ex16;

import net.mindview.util.FiveTuple;
import net.mindview.util.TwoTuple;

import static net.mindview.util.Tuple.tuple;

class SixTuple<A,B,C,D,E,F> extends FiveTuple<A,B,C,D,E>{
    private F sixth;
    public SixTuple(A a, B b, C c, D d, E e,F f) {
        super(a, b, c, d, e);
        this.sixth = f;
    }
    public String toString() {
        return "(" + this.first + ", " + this.second + ", " + this.third + ", "
                + this.fourth + ", " + this.fifth +", " + this.sixth + ")";
    }
}

class Tuple{
    public static <A,B,C,D,E,F> SixTuple<A,B,C,D,E,F> tuple(A a, B b, C c, D d, E e,F f){
        return new SixTuple<>(a, b, c, d, e, f);
    }
}

public class TupleTest2 {
    static TwoTuple<String,Integer> f() {
        return tuple("hi",47);
    }
    static TwoTuple f2() { return tuple("hi",47); }

    static SixTuple f6() { return Tuple.tuple("1","2","3","4","5","6"); }

    public static void main(String[] args) {
        TwoTuple<String,Integer> ttsi = f();
        System.out.println(ttsi);
        TwoTuple<Integer,Integer> ttsi2 = f2();
        System.out.println(ttsi2);
        System.out.println(f6());
    }
}
