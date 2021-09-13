import java.util.concurrent.TimeUnit;

public class InterruptingIdiom {

    public static void main(String[] args) throws InterruptedException {
        //test
        args = new String[]{"3000"};

        if (args.length !=1) {
            System.out.println("usage: java InterruptingIdiom delay-in-ms");
            System.exit(1);
        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(Integer.parseInt(args[0]));
        t.interrupt();
    }
}
