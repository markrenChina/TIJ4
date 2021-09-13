import java.util.concurrent.PriorityBlockingQueue;

import static net.mindview.util.Print.print;

public class PrioritizedTaskConsumer implements Runnable{

    private PriorityBlockingQueue<Runnable> queue;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                //Use current thread to run the task
                queue.take().run();
            }
        }catch (InterruptedException e){

        }
        print("Finished PrioritizedTaskConsumer");
    }
}
