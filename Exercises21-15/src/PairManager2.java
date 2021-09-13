
//Use a critical section
public class PairManager2 extends PairManager{
    /**
     * 只对方法块进行控制 checkCounter（另一个线程访问）优于PairManager1
     */
    @Override
    public void increment() {
        Pair temp;
        synchronized (this){
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}
