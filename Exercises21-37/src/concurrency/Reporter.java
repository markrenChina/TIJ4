package concurrency;

public class Reporter implements Runnable{
    private CarQueue carQueue;

    public Reporter(CarQueue carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println(carQueue.take());
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
    }
}
