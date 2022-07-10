package ex13;

import typeinfo.Part;
import typeinfo.TypeCounter;

import java.util.stream.IntStream;

public class Ex13 {

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Part.class);
        IntStream.range(0,10).forEach(i-> counter.count(Part.createRandom()));
        System.out.println();
        System.out.println(counter);
    }
}
