import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

public class TestBlockingQueues {

    static void getKey() {
        //Compensate for Windows/Linux difference in the
        //length of the result produced by the Enter key
        try {
            new BufferedReader(
                    new InputStreamReader(System.in)
            ).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void getKey(String message){
        System.out.println(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i=0;i<5;i++){
            runner.add(new LiftOff(5));
        }
        getKey("Press 'Enter' (" +msg +")");
        t.interrupt();
        System.out.println("Finished " + msg + " test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue",//Unlimited size
                new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue",//Fixed size
                new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue",//Size of 1
                new SynchronousQueue<>());
    }
}
