package ex24;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 背压问题
 */
public class Ex24 {

    private static ExecutorService exec = Executors.newCachedThreadPool();
    private static Producer producer = new Producer();
    private static Consumer consumer = new Consumer();

    public static void main(String[] args) {
        exec.execute(producer);
        exec.execute(consumer);
    }
}
