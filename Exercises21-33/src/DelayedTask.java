
import java.util.ArrayList;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.*;
import static net.mindview.util.Print.*;


public class DelayedTask implements Runnable, Delayed {

    private static int counter  = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;

    /**
     * static 跟构造函数搭配 用于保存创建顺序
     */
    protected static ArrayList<DelayedTask> sequence = new ArrayList<DelayedTask>();

    public DelayedTask(int delayInMilliseconds) {
        this.delta = delayInMilliseconds;
        this.trigger = System.nanoTime() + NANOSECONDS.convert(delta,MILLISECONDS);
        sequence.add(this);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedTask that = (DelayedTask) o;
        if (trigger < that.trigger) { return -1; }
        if (trigger > that.trigger) { return 1; }
        return 0;
    }

    @Override
    public void run() {
        printnb(this + " ");
    }

    /**
     * @param unit TimeUnit 入参 无需关心转换单位，将算法入参，策略模式
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(),NANOSECONDS);
    }

    @Override
    public String toString() {
        return String.format("[%1$-4d]",delta) + " Task " + id;
    }

    public String summary() {
        return "(" + id + ":" + delta +")";
    }

    /**
     * 将这个放置在队列最后一个，提供关闭的途径
     */
    public static class EndSentinel extends DelayedTask {

        private ExecutorService exec;

        public EndSentinel(int delay,ExecutorService e) {
            super(delay);
            exec = e;
        }

        @Override
        public void run() {
            for (DelayedTask delayedTask : sequence) {
                printnb(delayedTask.summary() + " ");
            }
            print();
            print(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}
