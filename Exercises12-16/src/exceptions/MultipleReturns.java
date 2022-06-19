package exceptions;

import java.util.stream.IntStream;

public class MultipleReturns {

    public static void f(int i) {
        System.out.println("Initalization that requires cleanup");
        try {
            System.out.println("Point 1");
            if ( i == 1) return;
            System.out.println("Point 2");
            if ( i == 2) return;
            System.out.println("Point 3");
            if ( i == 3) return;
            System.out.println("End");
            return;
        }finally {
            System.out.println("Performing cleanup");
        }
    }

    public static void main(String[] args) {
        IntStream.range(1,4).forEach(MultipleReturns::f);
    }
}
