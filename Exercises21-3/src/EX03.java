import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class EX03 {

    public static void main(String[] args) {
        ExecutorService singleExec = Executors.newSingleThreadExecutor();
        Stream.iterate(0, n -> n + 1)
                .limit(100)
                .map(i -> new MThread("Thread " + i + ":"))
                .forEach(singleExec::execute);
    }

    static class MThread implements Runnable {

        private String msg = null;

        public MThread(String msg) {
            this.msg = msg;
            System.out.println("start Thread for " + msg);
        }

        public MThread() {
        }

        @Override
        public void run() {
            System.out.println(msg);
            Thread.yield();
            System.out.println(msg);
            Thread.yield();
            System.out.println(msg);
            Thread.yield();
            System.out.println("close Thread for msg");
        }
    }
}
