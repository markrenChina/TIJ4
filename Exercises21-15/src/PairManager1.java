

//Synchronize the entire method
public class PairManager1 extends PairManager{
    /**
     * 全方法控制 checkCounter（另一个线程访问）不如PairManager2
     */
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
