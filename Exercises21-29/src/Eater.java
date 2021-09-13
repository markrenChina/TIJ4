import java.util.concurrent.TimeUnit;

public class Eater implements Runnable{

    private ToastQueue finishedQueue;
    private int counter = 0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                //Blocks until next piece of toast is acailable
                Toast t = finishedQueue.take();
                //Verify that the toast is coming in order,
                //and that all pieces are getting jammed
                if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED){
                    System.out.println(">>>>> Error: "+ t);
                    System.exit(1);
                }else {
                    System.out.println("Chomp! " + t);
                }
            }
        }catch (InterruptedException e){
            System.out.println("Toaster interrupted");
        }
        System.out.println("Toaster off");
    }
}
