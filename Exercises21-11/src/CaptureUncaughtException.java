import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//https://stackoverflow.com/questions/68418445/this-code-from-thinking-in-java-4-page-673-i-can-not-get-planned-results
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
