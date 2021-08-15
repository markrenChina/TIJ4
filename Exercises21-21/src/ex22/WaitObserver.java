package ex22;

public class WaitObserver implements Runnable{

    final Observable observable;

    public WaitObserver(Observable observable) {
        this.observable = observable;
        new Thread(observable).start();
    }

    @Override
    public void run() {
        for (;;){
            if (observable.getFlag()){
                synchronized (observable){
                    observable.setFlag(false);
                    try {
                        observable.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(System.currentTimeMillis() + " change flag to false");
            }else {
                synchronized (observable){
                    try {
                        observable.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(System.currentTimeMillis() + " no need change ");
            }

        }
    }
}
