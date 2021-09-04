import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public class PrioritizedTask implements Runnable,Comparable<PrioritizedTask>{

    private Random rand = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequence = new ArrayList<PrioritizedTask>();
    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        return Integer.compare(o.priority, priority);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        } catch (InterruptedException e) {
            //exit
        }
        print(this);
    }

    @Override
    public String toString() {
        return String.format("[%1$-3d]",priority) + " Task " + id;
    }

    public String summary() {
        return "(" + id + ":" + priority + ")";
    }

    public static class EndSentinel extends PrioritizedTask {

        private ExecutorService exec;

        public EndSentinel(ExecutorService e) {
            super(-1);
            exec = e;
        }

        @Override
        public void run() {
            int count = 0;
            for (PrioritizedTask prioritizedTask : sequence) {
                printnb(prioritizedTask.summary());
                if (++count % 5 == 0){
                    print();
                }
            }
            print();
            print(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}
