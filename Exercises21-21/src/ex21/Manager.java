package ex21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Manager {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        var work = new WaitWorker();
        var f = exec.submit(work);
        TimeUnit.SECONDS.sleep(1);
        synchronized (work){
            work.notifyAll();
        }
        TimeUnit.SECONDS.sleep(1);
        f.cancel(true);
        System.out.println("system out");
    }
}
