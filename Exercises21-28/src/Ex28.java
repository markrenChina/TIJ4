import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Ex28 {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        exec.execute(new Runnable() {
            @Override
            public void run() {
                LiftOffRunner runner = new LiftOffRunner(new LinkedBlockingQueue<LiftOff>());
                for (int i=0;i<5;i++){
                    runner.add(new LiftOff(5));
                }
                exec.execute(runner);
                exec.shutdown();
                TestBlockingQueues.getKey("get key");
                System.out.println("Finished test");
            }
        });
    }
}
