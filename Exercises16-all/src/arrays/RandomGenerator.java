package arrays;

import net.mindview.util.Generator;

import java.util.Random;

public class RandomGenerator {
    private static Random r = new Random(47);

    public static class Boolean implements Generator<java.lang.Boolean> {

        @Override
        public java.lang.Boolean next() {
            return r.nextBoolean();
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        @Override
        public java.lang.Byte next() {
            return (byte) r.nextInt();
        }
    }

    public static class Character implements Generator<java.lang.Character> {
        @Override
        public java.lang.Character next() {
            return CountingGenerator.chars[r.nextInt(CountingGenerator.chars.length)];
        }
    }

    public static class String extends CountingGenerator.String {
        //Plug in the random Character generator
        { cg = new Character(); } //Instance initializer

        public String() {}

        public String(int length) {
            super(length);
        }
    }

    //...
}
