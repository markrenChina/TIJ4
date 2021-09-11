import net.mindview.util.BasicGenerator;

import java.util.List;
import java.util.concurrent.*;

public class ExchangerDemo {

    static int size = 10;
    //Seconds
    static int delay = 5;

    public static void main(String[] args) throws InterruptedException {
        if (args.length > 0){
            size = new Integer(args[0]);
        }
        if (args.length > 1) {
            delay = new Integer(args[1]);
        }
        System.out.println("1");
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> xc = new Exchanger<List<Fat>>();
        List<Fat> producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();

        System.out.println("2");
        exec.execute(new ExchangerProducer<Fat>(xc, BasicGenerator.create(Fat.class),producerList));
        System.out.println("3");
        exec.execute(new ExchangerConsumer<>(xc,consumerList));
        System.out.println("4");
        TimeUnit.SECONDS.sleep(delay);
        System.out.println("5");
        exec.shutdownNow();
    }
}
