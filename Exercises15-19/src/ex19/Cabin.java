package ex19;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Cabin extends ArrayList<Holds> {
    public Cabin(int nHolds,int nProducts) {
        IntStream.range(0,nHolds).forEach(i-> {
            add(new Holds(nProducts));
        });
    }
}
