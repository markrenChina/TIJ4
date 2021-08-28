import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex29 {

    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue1  = new ToastQueue(),
                dryQueue2  = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue1));
        exec.execute(new Toaster(dryQueue2));
        exec.execute(new Butterer(dryQueue1,finishedQueue));
        exec.execute(new Jammer(dryQueue2,finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
