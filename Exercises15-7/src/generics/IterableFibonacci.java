package generics;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer>{

    private int n;

    public IterableFibonacci(int n) {
        this.n = n;
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
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                //调用父类继承来的next方法
                return IterableFibonacci.this.next();
            }
        };
    }
}
