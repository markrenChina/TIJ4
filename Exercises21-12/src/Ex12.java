import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Ex12 {
}

class AtomicityTest implements Runnable {
    private int i = 0;
    //ex 12 add synchronized
    public synchronized int getValue() { return i; }
    private synchronized void evenIncrement() {i++;i++;}

    @Override
    public void run() {
        while (true) evenIncrement();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
