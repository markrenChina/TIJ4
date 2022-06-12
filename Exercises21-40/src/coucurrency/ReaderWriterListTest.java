package coucurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ReaderWriterListTest {
    private final static int SIZE = 100;
    private static Random rand = new Random(47);
    ExecutorService exec = Executors.newCachedThreadPool();
    private ReaderWriterList<Integer> list = new ReaderWriterList<>(SIZE,0);
    public ReaderWriterListTest(int readers, int writers) {
        IntStream.range(0,readers).forEach(i -> exec.execute(new Reader()));
        IntStream.range(0,writers).forEach(i -> exec.execute(new Writer()));

    }

    private class Writer implements Runnable{

        @Override
        public void run() {
            try {
                for (int i = 0; i < 20; i++) {
                    list.set(i, rand.nextInt());
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            }catch (InterruptedException e){
                //Acceptable way to exit
            }
            System.out.println("Writer finished,shutting down");
            exec.shutdownNow();
        }
    }

    private class Reader implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()){
                    for (int i = 0; i < SIZE; i++) {
                        list.get(i);
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                }
            }catch (InterruptedException e){
                //Acceptable way to exit
            }
        }
    }
}
