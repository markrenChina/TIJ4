import java.util.concurrent.TimeUnit;

/**
 * 显式锁可以被中断
 */
public class Interrupting2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t,interrupt");
        t.interrupt();
    }
}
