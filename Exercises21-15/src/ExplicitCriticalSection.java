/**
 * 锁不住
 */
public class ExplicitCriticalSection {

    public static void main(String[] args) {
        PairManager pairManager1 = new ExplicitPairManager1(),pairManager2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(pairManager1,pairManager2);
    }
}
