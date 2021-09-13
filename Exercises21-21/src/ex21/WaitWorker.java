package ex21;

public class WaitWorker implements Runnable{

    public synchronized void w() throws InterruptedException {
        wait();
    }

    @Override
    public void run() {
        try {
            w();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting waitWorker");
    }
}
