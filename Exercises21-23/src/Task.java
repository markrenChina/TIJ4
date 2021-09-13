public class Task implements Runnable{

    /**
     * static 所有Task共用 但不与Task2共用
     */
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
