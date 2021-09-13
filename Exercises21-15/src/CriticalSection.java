import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSection {
    //Test the two different approaches
    static void testApproaches(PairManager pairManager1, PairManager pairManager2){
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator pm1 = new PairManipulator(pairManager1),pm2 = new PairManipulator(pairManager2);
        PairChecker pcheck1 = new PairChecker(pairManager1),pcheck2 = new PairChecker(pairManager2);
        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pcheck1);
        exec.execute(pcheck2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
        System.out.println("pm1: " + pm1 + "\npm2: " + pm2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager pairManager1 = new PairManager1(),pairManager2 = new PairManager2();
        testApproaches(pairManager1,pairManager2);
    }
}
