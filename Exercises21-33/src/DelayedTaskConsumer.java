import java.util.concurrent.DelayQueue;

import static net.mindview.util.Print.print;

public class DelayedTaskConsumer implements Runnable{

    private DelayQueue<DelayedTask> queue;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                queue.take().run();
            }
        }catch (InterruptedException e){
            //exit
        }
        print("Finished DelayedTaskConsumer");
    }
}
