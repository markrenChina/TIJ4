import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex17 {
}


class Sensor implements Runnable{
    private int id;
    private Random rand = new Random(47);
    public volatile int radiate;

    public Sensor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (;;){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            radiate = rand.nextInt(20);
            Thread.yield();
        }
    }
}

class Counter{

    private int count = 0;
    private List<Sensor> sensors = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();

    public synchronized int getCount() {
        return count;
    }

    public synchronized void connect(int id){
        Sensor sensor = new Sensor(id);
        exec.execute(sensor);
        sensors.add(sensor);
        count++;
    }

    public int sum() {
        int sum = 0;
        for (Sensor sensor : sensors) {
            sum+= sensor.radiate;
        }
        return sum;
    }
}

class dev{
    private static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            counter.connect(i);
        }
        for (;;){
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(counter.sum());
        }
    }

}

