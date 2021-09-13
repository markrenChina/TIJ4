package ex22;

import java.util.concurrent.TimeUnit;

/**
 * 被观察者
 */
public class Observable implements Runnable {

    private boolean flag = false;

    public synchronized void setFlag(boolean b) {
        flag = b;
        notifyAll();
    }

    public synchronized boolean getFlag(){
        return flag;
    }

    @Override
    public void run() {
        for (;;){
            try {
                TimeUnit.SECONDS.sleep(1);
                setFlag(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
