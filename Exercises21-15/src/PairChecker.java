/**
 * 检查pm是否是正确的
 */
public class PairChecker implements Runnable{
    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        for (;;) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}
