package coucurrency2;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

//Framework to test performance of concurrency containers
public abstract class Tester<C> {

    static int testReps = 10;
    static int testCycles = 1000;
    static int containerSize = 1000;
    static ExecutorService exec = Executors.newCachedThreadPool();
    C testContainer;
    String testId;
    int nReaders;
    int nWriters;
    volatile long readResult = 0;
    volatile long readTime = 0;
    volatile long writeTime = 0;
    CountDownLatch endLatch;
    Integer[] writeData;
    Tester(String testId, int nReaders, int nWriters) {
        this.testId = testId + " " + nReaders + "r " + nWriters + "w";
        this.nReaders = nReaders;
        this.nWriters = nWriters;
        writeData = Generated.array(Integer.class,
                new RandomGenerator.Integer(),containerSize);
        IntStream.range(0,testReps).forEach(i ->{
            runTest();
            readTime = 0;
            writeTime = 0;
        });
    }

    public static void initMain(String[] args) {
        if (args.length > 0) {
            testReps = Integer.parseInt(args[0]);
        }
        if (args.length > 1){
            testCycles = Integer.parseInt(args[1]);
        }
        if (args.length > 2) {
            containerSize = Integer.parseInt(args[2]);
        }
        System.out.printf("%-27s %14s %14s%n","Type","Read time","Write time");
    }

    abstract C containerInitializer();

    abstract void startReadersAndWriters();

    void runTest(){
        endLatch = new CountDownLatch(nReaders + nWriters);
        testContainer = containerInitializer();
        startReadersAndWriters();
        try {
            endLatch.await();
        } catch (InterruptedException ex){
            System.out.println("endLatch interrupted");
        }
        System.out.printf("%-27s %14d %14d%n",testId,readTime,writeTime);
        if (readTime !=0 && writeTime !=0 ){
            System.out.printf("%-27s %14d%n","readTime + writeTime =",readTime+writeTime);
        }
    }

    abstract class TestTask implements Runnable{
        long duration;

        abstract void test();

        abstract void putResults();

        @Override
        public void run() {
            long startTime = System.nanoTime();
            test();
            duration = System.nanoTime() - startTime;
            synchronized (Tester.this){
                putResults();
            }
            endLatch.countDown();
        }
    }
}