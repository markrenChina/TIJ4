package util;

public class ThreeTuple<A,B,C> extends TwoTuple<A,B>{

    public final C third;
    public ThreeTuple(A first, B second, C c) {
        super(first, second);
        third = c;
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "third=" + third +
                "} " + super.toString();
    }
}
