import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Ex14 {

    private static AtomicInteger count = new AtomicInteger(4000);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 4000; i++) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("closed" + count.addAndGet(-1));
                }
            },3000);
            Thread.yield();
        }

        Thread.sleep(6000);
        System.out.println("=====================================================");
        System.out.println(count.get());
    }
}
