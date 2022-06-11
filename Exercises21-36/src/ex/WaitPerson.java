package ex;

import menu.Food;
import restaurant2.Order;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WaitPerson implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private final restaurant2.Restaurant restaurant;
    BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();
    public WaitPerson(Restaurant rest) { restaurant = rest; }

    public void placeOrder(Customer cust, Food food){
        try {
            //Shouldn't actually block because this is
            //a LinkedBlockingQueue with no size limit
            restaurant.orders.put(new Order(cust,this,food));
        } catch (InterruptedException e) {
            System.out.println(this + " placeOrder interrupted");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                //Blocks until a course is ready
                Plate plate = filledOrders.take();
                System.out.println(this + "received " + plate + " delivering to "
                + plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off duty");
    }

    @Override
    public String toString() {
        return "WaitPerson{" +
                "id=" + id +
                '}';
    }
}
