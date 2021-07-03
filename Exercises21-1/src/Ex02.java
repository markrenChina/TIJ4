import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex02 {
    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.iterate(0, n -> n + 1)
                .limit(10)
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
        Fibonacci gen = new Fibonacci();
        List<Integer> list =  Stream.iterate(0, n -> n + 1)
                .limit(number - 1)
                .map(i -> gen.next())
                .collect(Collectors.toList());
        System.out.println(list);
    }
}