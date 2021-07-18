import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//https://stackoverflow.com/questions/68418445/this-code-from-thinking-in-java-4-page-673-i-can-not-get-planned-results
public class CaptureUncaughtException {

    public volatile static int testThreadPoolExecutor = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
        TimeUnit.SECONDS.sleep(3);
        System.out.println(testThreadPoolExecutor);
    }
}
