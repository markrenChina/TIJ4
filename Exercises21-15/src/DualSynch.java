public class DualSynch {
    private final Object syncObject = new Object();

    public synchronized void f() {
        for (int i = 0; i < 50; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }

    public void g() {
        synchronized (syncObject){
            for (int i = 0; i < 50; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
