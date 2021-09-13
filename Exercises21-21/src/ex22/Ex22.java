package ex22;

public class Ex22 {

    public static void test (Runnable r) {
        new Thread(r).start();
    }

    public static void main(String[] args) {
        var observable = new Observable();
        var spinObserver = new SpinObserver(observable);
        var waitObserver = new WaitObserver(observable);
        //test(spinObserver);
        test(waitObserver);
    }
}
