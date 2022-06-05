package enumerated;

import net.mindview.util.Generator;

import java.util.stream.IntStream;

public class EnumImplementation {

    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ". ");
    }

    public static void main(String[] args) {
        //Choose any instance 必须要先实例一下
        CartoonCharacter cc = CartoonCharacter.BOB;
        IntStream.range(0,10).forEach(i -> printNext(cc));
    }
}
