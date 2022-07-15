package ex7;

import generics.Fibonacci;
import generics.IterableFibonacci;

import java.util.Iterator;

public class Ex7 implements Iterable<Integer>{
    private final Fibonacci compose;
    private int size;

    public Ex7(int capSize, Fibonacci compose) {
        this.size = capSize;
        this.compose = compose;
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18)) {
            System.out.print(i + " ");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public Integer next() {
                size--;
                if (size < 0){
                    throw new  IndexOutOfBoundsException();
                }else {
                    return compose.next();
                }
            }
        };
    }
}
