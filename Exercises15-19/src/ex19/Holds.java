package ex19;

import generics.Generators;

import java.util.ArrayList;

public class Holds extends ArrayList<Product> {
    public Holds(int initialCapacity) {
        Generators.fill(this,Product.generator,initialCapacity);
    }
}
