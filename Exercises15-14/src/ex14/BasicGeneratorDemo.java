package ex14;

import generics.CountedObject;
import net.mindview.util.Generator;
import util.BasicGenerator;

public class BasicGeneratorDemo {

    public static void main(String[] args) {

        Generator<CountedObject> gen = new BasicGenerator<CountedObject>(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
}
