package generics;

import net.mindview.util.FourTuple;

import java.util.ArrayList;

public class TupleList<A,B,C,D> extends ArrayList<FourTuple<A,B,C,D>> {
    public static void main(String[] args) {
        TupleList<Integer,Float,String,Object> tl = new TupleList<>();
        tl.add(new FourTuple(1,2.0,"3",new Boolean(true)));
        System.out.println(tl.get(0));
    }

}
