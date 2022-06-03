package ex24;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 背压问题
 */
public class Ex24 {

    private static ExecutorService exec = Executors.newCachedThreadPool();
    private static SourceBuffer sb = new SourceBuffer();
    static Producer producer = new Producer(sb);
    static Consumer consumer = new Consumer(sb);

    public static void main(String[] args) {
        exec.execute(consumer);
        exec.execute(producer);
    }
}