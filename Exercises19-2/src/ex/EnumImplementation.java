package ex;


import java.util.stream.IntStream;

public class EnumImplementation {

    public static void printNext() {
        System.out.print(CartoonCharacter.next() + ". ");
    }

    public static void main(String[] args) {
        //CartoonCharacter cc = CartoonCharacter.BOB;
        IntStream.range(0,10).forEach(i -> printNext());
    }
}
