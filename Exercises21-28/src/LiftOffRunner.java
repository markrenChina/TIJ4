import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * 同步队列，在一个线程重切换不同的工作内容（事件）
 */
public class LiftOffRunner implements Runnable{
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        this.rockets = queue;
    }

    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        while(!Thread.interrupted()){
            LiftOff rocket = null;
            try {
                rocket = rockets.take();
                rocket.run();
            } catch (InterruptedException e) {
                System.out.println("Waking from take()");
            }
            System.out.println("Exiting LiftOffRunner");
        }
    }
}
