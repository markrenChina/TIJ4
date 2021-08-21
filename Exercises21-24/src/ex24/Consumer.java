package ex24;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
    private SourceBuffer sb;

    public Consumer(SourceBuffer sb) {
        this.sb = sb;
    }

    private Random rand = ThreadLocalRandom.current();

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (sb.list.isEmpty()) {
                        System.out.println("Consumer wait");
                        wait();
                    }
                }
                var dur= rand.nextInt(1000);
                TimeUnit.MILLISECONDS.sleep(dur);
                System.out.println("start Consumer");
                Source s = sb.pop();
                s = null;
                System.out.println("Consumer end size = " + sb.list.size());
                synchronized (Ex24.producer){
                    Ex24.producer.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
