package ex23and24;

/**
 * waxOn 表示涂蜡-抛光的处理状态
 */
public class Car {
    private boolean waxOn = false;

    /**
     * 打蜡完成，修改状态，并唤醒抛光
     */
    public synchronized void waxed() {
        waxOn = true; //Read to buff
        notify();
    }

    /**
     * 抛光完成 修改状态，并唤醒打蜡
     */
    public synchronized void buffed(){
        waxOn = false;
        notify();
    }

    /**
     * 抛光完成时，调用wait释放锁
     * @throws InterruptedException
     */
    public synchronized void waitForWaxing() throws InterruptedException {
        while (!waxOn){
            wait();
        }
    }

    /**
     * 打蜡完成时，释放锁
     * @throws InterruptedException
     */
    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn){
            wait();
        }
    }
}
