import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.*;

public class Ex30 {

    public static void main(String[] args) throws Exception{
        BlockingQueue<String> bq = new LinkedBlockingQueue<>();
        SenderEx sender = new SenderEx(bq);
        ReceiverEx receiver = new ReceiverEx(bq);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}

class ReceiverEx implements Runnable{

    private BlockingQueue<String> shareQueue;

    public ReceiverEx(BlockingQueue queue) {
        this.shareQueue = queue;
    }

    @Override
    public void run() {
        while (true){
            //Blocks until characters are there
            String c = shareQueue.poll();
            if (c != null){
                System.out.println("Read: " + c+ ", ");
            }
        }
    }
}

class SenderEx implements Runnable{

    private Random rand = new Random(47);
    private BlockingQueue<String> shareQueue;

    public SenderEx(BlockingQueue queue) {
        this.shareQueue = queue;
    }

    @Override
    public void run() {
        try{
            while (true){
                for (char c = 'A' ; c <= 'Z';c++){
                    shareQueue.put(c+"");
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e + " Sender sleep interrupted");
        }
    }
}
