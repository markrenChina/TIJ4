import java.util.concurrent.TimeUnit;

/**
 * 线程中检查中断并正确清理资源示例
 */
public class Blocked3 implements Runnable{

    private volatile double d= 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //point1
                NeedsCleanup n1 = new NeedsCleanup(1);
                //Start try-finally immediately after definition
                //of n1, to guarantee proper cleanup of n1
                try {
                    System.out.println("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    //point2
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    //Guarantee proper cleanup of n2
                    try {
                        System.out.println("Calculating");
                        //A time-consuming ,non-blocking operation
                        for (int i = 0; i < 2_500_000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        System.out.println("Finished time-consuming operation");
                    } finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("Exiting via while() test");
        }catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        }
    }
}
