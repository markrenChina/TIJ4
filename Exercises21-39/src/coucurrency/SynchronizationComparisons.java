package coucurrency;

import java.util.stream.IntStream;

public class SynchronizationComparisons {
    static BaseLine baseLine = new BaseLine();
    static SynchronizedTest synch = new SynchronizedTest();
    static LockTest lock = new LockTest();
    static AtomicTest atomic = new AtomicTest();

    static void test(){
        System.out.println("=================");
        System.out.printf("%-12s : %13d\n","Cycles",Accumulator.cycles);
        baseLine.timedTest();
        synch.timedTest();
        lock.timedTest();
        atomic.timedTest();
        Accumulator.report(synch,baseLine);
        Accumulator.report(lock,baseLine);
        Accumulator.report(atomic,baseLine);
        Accumulator.report(synch,atomic);
        Accumulator.report(lock,atomic);
    }

    public static void main(String[] args) {
        int iterations = 15; //Default
        if (args.length >0){
            //Optionally change iterations
            iterations = new Integer(args[0]);
        }
        //The first time fills the thread pool
        System.out.println("Warmup");
        baseLine.timedTest();
        //Now the initial test doesn't include the cost
        //of starting the threads for the first time
        //Produce multiple data points
        IntStream.range(0,iterations).forEach( i -> {
            test();
            Accumulator.cycles *= 2;
        });
        Accumulator.exec.shutdownNow();
    }
}
