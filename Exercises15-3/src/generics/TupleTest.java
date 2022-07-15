package generics;

import util.ThreeTuple;
import util.TwoTuple;

class Amphibian {}
class Vehicle {}

public class TupleTest {
    static TwoTuple<String,Integer> f() {
        //Autoboxing converts the int to Integer
        return new TwoTuple<>("hi",47);
    }

    static ThreeTuple<Amphibian,String,Integer> g(){
        return new ThreeTuple<>(new Amphibian(),"hi",47);
    }

    public static void main(String[] args) {
        var ttsi = f();
        System.out.println(ttsi);
        System.out.println(g());
    }
}
