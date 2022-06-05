package ex35;

import bankdemo.CustomerGenerator;
import bankdemo.CustomerLine;
import bankdemo.TellerManager;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WebTellerSimulation {
    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENT_PERIOD = 1000;

    public static void main(String[] args) throws InterruptedException, IOException {
        ExecutorService exec = Executors.newCachedThreadPool();
        CustomerLine severs = new CustomerLine(MAX_LINE_SIZE);
        exec.execute(new CustomerGenerator(severs));
        //Manager will add and remove tellers as necessary;
        exec.execute(new TellerManager(exec,severs,ADJUSTMENT_PERIOD));
        if (args.length > 0){
            //Optional argument
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        }else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}
