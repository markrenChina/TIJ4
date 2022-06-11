package coucurrency;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

abstract class Accumulator {

    protected final static int SIZE = 100_000;
    //Number of Modifiers and Readers during each test;
    private static final int N =4;
    public static long cycles = 50_000L;
    public static ExecutorService exec = Executors.newFixedThreadPool(N * 2);
    protected static int[] preLoaded = new int[SIZE];
    private static CyclicBarrier barrier = new CyclicBarrier(N *2 +1);

    static {
        //Load the array of random numbers
        Random rand = new Random(47);
        IntStream.range(0,SIZE).forEach(i -> preLoaded[i] = rand.nextInt());
    }

    protected volatile int index = 0;
    protected volatile long value = 0;
    protected long duration = 0;
    protected String id = "error";

    public static void report(Accumulator acc1,Accumulator acc2){
        System.out.printf("%-22s: %.2f\n",acc1.id + "/" + acc2.id,
                (double)acc1.duration /(double) acc2.duration);
    }

    public abstract void accumulate();

    public abstract long read();

    public void timedTest(){
        long start = System.nanoTime();
        IntStream.range(0,N).forEach(i-> {
            exec.execute(new Modifier());
            exec.execute(new Reader());
        });
        try {
            barrier.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        duration = System.nanoTime() - start;
        System.out.printf("%-13s: %13d : %20d \n",id,duration,read());
    }

    private class Modifier implements Runnable {

        @Override
        public void run() {
            LongStream.range(0,cycles).forEach(l-> accumulate());
            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class Reader implements Runnable{
        private volatile long value;
        @Override
        public void run() {
            LongStream.range(0,cycles).forEach(l-> value = read());
            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
