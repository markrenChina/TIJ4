package ex;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex10 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        ThreadMethod threadMethod = new ThreadMethod();
        System.out.println(threadMethod.runTask(random.nextInt(20)).get());
        System.out.println(threadMethod.runTask(random.nextInt(20)).get());
        System.out.println(threadMethod.runTask(random.nextInt(20)).get());
        System.out.println(threadMethod.runTask(random.nextInt(20)).get());
        System.out.println(threadMethod.runTask(random.nextInt(20)).get());
        System.out.println(threadMethod.runTask(random.nextInt(20)).get());
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

class ThreadMethod  {

    private ExecutorService exec = Executors.newCachedThreadPool();

    public ThreadMethod() { }

    public Future<List<Integer>> runTask(int number) {
        return exec.submit(new Job(number));
    }

}
