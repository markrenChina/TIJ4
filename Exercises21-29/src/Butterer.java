import java.util.concurrent.TimeUnit;

public class Butterer implements Runnable{

    private ToastQueue dryQueue,butteredQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                //Blocks until next piece of toast is available
                Toast t = dryQueue.take();
                t.butter();
                System.out.println(t);
                butteredQueue.put(t);
            }
        }catch (InterruptedException e){
            System.out.println("Butterer interrupted");
        }
        System.out.println("Butterer off");
    }
}
