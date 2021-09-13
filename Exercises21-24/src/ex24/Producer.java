package ex24;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {

    private SourceBuffer sb;

    public Producer(SourceBuffer sb) {
        this.sb = sb;
    }

    private Random rand = ThreadLocalRandom.current();

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (sb.list.size() == sb.buffSize) {
                        System.out.println("Producer wait");
                        wait();
                    }
                }
                var dur= rand.nextInt(1000);
                TimeUnit.MILLISECONDS.sleep(dur);
                System.out.println("start Producer");
                Source s = new Source(dur + "");
                sb.offer(s);
                System.out.println("Producer end size = " + sb.list.size());
                synchronized (Ex24.consumer){
                    Ex24.consumer.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
