package coucurrency3;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FastSimulation {
    static final int N_ELEMENTS = 100_000;
    static final int N_GENES = 30;
    static final int N_EVOLVERS = 50;
    static final AtomicInteger[][] GRID =
            new AtomicInteger[N_ELEMENTS][N_GENES];
    static Random random = new Random(47);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0,N_ELEMENTS).forEach(i -> {
            IntStream.range(0,N_GENES).forEach(j ->
                    GRID[i][j] = new AtomicInteger(random.nextInt(1000)));
        });
        IntStream.range(0,N_EVOLVERS).forEach(i -> {
            exec.execute(new Evoler());
        });
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }

    static class Evoler implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()){
                //Randomly select an element to work on:
                int element = random.nextInt(N_ELEMENTS);
                IntStream.range(0,N_GENES).forEach(i -> {
                    int previous = element -1;
                    if (previous < 0) {
                        previous = N_ELEMENTS -1;
                    }
                    int next = element + 1;
                    if (next >= N_ELEMENTS) next=0;
                    int oldValue = GRID[element][i].get();
                    //Perform sone kind if modeling calculation
                    int newvalue = oldValue + GRID[previous][i].get()
                            +GRID[next][i].get();
                    newvalue /=3; //Average the three values
                    //assert (oldValue == GRID[element][i].get());
                    if (!GRID[element][i].compareAndSet(oldValue,newvalue)){
                        //Policy here to deal with failure.Here, we
                        //just report it and ignore it; our model
                        //will eventually deal with it
                        System.out.println("Old value changed from " + oldValue);
                    }
                });
            }
        }
    }
}
