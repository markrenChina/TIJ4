package ex;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class RandomInteger implements Comparable<RandomInteger> {
    static Random random = ThreadLocalRandom.current();
    private final Integer value;

    public RandomInteger() {
        this.value = random.nextInt(100);
    }

    @Override
    public int compareTo(RandomInteger o) {
        //0 ~ 100 Will not overflow.
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "RandomInteger{" +
                "value=" + value +
                '}';
    }
}

public class Ex11 {

    public static void main(String[] args) {
        PriorityQueue<RandomInteger> queue = new PriorityQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.add(new RandomInteger());
        }
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.poll());
        }
    }
}
