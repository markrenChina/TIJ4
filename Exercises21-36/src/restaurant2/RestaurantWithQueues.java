package restaurant2;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RestaurantWithQueues {

    public static void main(String[] args) throws InterruptedException, IOException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant(exec,5,2);
        exec.execute(restaurant);
        if (args.length > 0){
            //Optional argument
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        }else {
            System.out.println("press 'Enter' to quit" );
            System.in.read();
        }
        exec.shutdownNow();
    }
}
