package bankdemo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

//Randomly add customers to a queue
public class CustomerGenerator implements Runnable{
    private static Random rand = new Random(47);
    private CustomerLine customers;

    public CustomerGenerator(CustomerLine customers) {
        this.customers = customers;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                customers.put(new Customer(rand.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            System.out.println("CustomerGenerator interrupted");
        }
        System.out.println("CustomerGenerator terminating");
    }
}
