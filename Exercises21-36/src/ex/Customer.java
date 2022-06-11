package ex;

import menu.Course;
import menu.Food;

import java.util.concurrent.SynchronousQueue;

public class Customer implements Runnable{

    private static int counter = 0;
    private final int id = counter++;
    private final WaitPerson waitPerson;
    //Only one course at a time can be received:
    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();

    public Customer(WaitPerson waitPerson) {
        this.waitPerson = waitPerson;
    }

    public void deliver(Plate p) throws InterruptedException {
        //Only blocks if customer is still
        //eating the previous course:
        placeSetting.put(p);
    }

    @Override
    public void run() {
        for (Course course : Course.values()) {
            Food food = course.randomSelection();
            try {
                waitPerson.placeOrder(this,food);
                //Blocks until course has been delivered
                System.out.println(this + "eating " + placeSetting.take());
            } catch (InterruptedException e) {
                System.out.println(this + "waiting for " + course + " interrupted");
                break;
            }
        }
        System.out.println(this + "finished meal. leaving");
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }
}
