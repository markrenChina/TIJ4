import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex06 {

    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.iterate(0, n -> n + 1)
                .limit(20)
                .forEach(e -> (new Thread(new Job(random.nextInt(20)))).start());
    }
}

class Job implements Runnable{

    private int number = 0;
    public Job(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(number);
    }
}
