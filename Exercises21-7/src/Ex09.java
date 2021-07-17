import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Ex09 implements Runnable{

    private int countDown = 5;
    /**
     * No optimization
     */
    private volatile double d;

    public Ex09() { }

    @Override
    public String toString() {
        return Thread.currentThread() + " : "  + countDown;
    }

    @Override
    public void run() {
        //Thread.currentThread().setPriority(priority);
        while (true) {
            //An expensive, interruptable operation
            for (int i = 1; i<100000; i++){
                d += (Math.PI + Math.E) / (double)i;
                if (i % 1000 ==0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int p = 0;
        switch(rand.nextInt(3)) {
            case 0 : p = Thread.MIN_PRIORITY; break;
            case 1 : p = Thread.NORM_PRIORITY; break;
            case 2 : p = Thread.MAX_PRIORITY; break;
            default:
        }
        ExecutorService exec = Executors.newCachedThreadPool( new PriorityThreadFactory(p));
        for (int i =0 ;i < 5; i ++){
            exec.execute(new Ex09());
        }
        exec.shutdown();
    }
}


class PriorityThreadFactory implements ThreadFactory{

    private int priority;

    public PriorityThreadFactory(int priority) {
        this.priority = priority;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(priority);
        return t;
    }
}


