import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex05 {

    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        ExecutorService exec = Executors.newCachedThreadPool();
        Stream.iterate(0, n -> n + 1)
                .limit(10)
                .map(e -> exec.submit(new Job(random.nextInt(20))))
                .forEach(future -> {
                    try {
                        System.out.println(future.get());
                    } catch (InterruptedException | ExecutionException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                });
    }
}

class Job implements Callable<List<Integer>> {

    private int number = 0;

    public Job(int number) {
        this.number = number;
    }

    @Override
    public List<Integer> call() throws Exception {
        Fibonacci gen = new Fibonacci();
        return Stream.iterate(0, n -> n + 1)
                .limit(number - 1)
                .map(i -> gen.next())
                .collect(Collectors.toList());
    }
}
