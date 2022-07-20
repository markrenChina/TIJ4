package ex18;

import generics.Generators;
import net.mindview.util.Generator;

import java.util.*;

class LittleFish {
    private static long counter = 1;
    private final long id = counter++;
    private LittleFish() {}

    //A method to produce Generator objects:
    public static Generator<LittleFish> generator() {
        return new Generator<LittleFish>() {
            public LittleFish next() { return new LittleFish(); }
        };
    }

    public String toString() { return "LittleFish "+ id; }
}

class BigFish {
    // A single Generator object
    public static Generator<BigFish> generator =
            new Generator<BigFish>() {
                @Override
                public BigFish next() {
                    return new BigFish();
                }
            };
    private static long counter = 1;
    private final long id = counter++;
    private BigFish() {}

    public String toString() { return "BigFish "+ id; }
}

public class Ex18 {
    public static void serve(BigFish t, LittleFish c) {
        System.out.println(t + " eat " + c);
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        Queue<LittleFish> line = new LinkedList<>();
        Generators.fill(line, LittleFish.generator(),15);
        List<BigFish> tellers = new ArrayList<>();
        Generators.fill(tellers, BigFish.generator,4);
        for (LittleFish c : line) {
            serve(tellers.get(rand.nextInt(tellers.size())),c );
        }
    }
}
