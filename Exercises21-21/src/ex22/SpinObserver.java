package ex22;

import java.util.concurrent.TimeUnit;

/**
 * 自旋观察者
 */
public class SpinObserver implements Runnable{

    Observable observable;

    public SpinObserver(Observable observable) {
        this.observable = observable;
        new Thread(observable).start();
    }

    @Override
    public void run() {
        for (;;){
            if (observable.getFlag()){
                observable.setFlag(false);
                System.out.println(System.currentTimeMillis() + " change flag to false");
            }else {
                System.out.println(System.currentTimeMillis() + " no need change ");
            }
        }
    }
}
