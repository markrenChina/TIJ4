import java.util.concurrent.TimeUnit;

public class Ex08 {

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 5; i++) {
            new SimpleThread();
        }
        TimeUnit.SECONDS.sleep(3);
    }
}


class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;
    public SimpleThread() {
        // Store the thread name:
        super(Integer.toString(++threadCount));
        //add
        setDaemon(true);
        start();
    }
    @Override
    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }
    @Override
    public void run() {
        while(true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.print(this);
                if(--countDown == 0) {
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
