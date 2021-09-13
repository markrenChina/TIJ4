
/**
 * 服务员
 * 当没有meal时wait 自身
 * 被唤醒后消费meal 并唤醒chef
 */
public class WaitPerson implements Runnable {

    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    //while 放置里面保证等待的原子性
                    while (restaurant.meal == null ||!restaurant.table.state) {
                        wait(); //... for the chef to produce a meal
                    }
                }
                System.out.println("meal is " + (restaurant.meal == null) + " table is " + restaurant.table.state);
                System.out.println("Waitperson got " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.table.state = false;
                    restaurant.chef.notifyAll(); //Ready for another
                }
                synchronized (restaurant.busBoy){
                    restaurant.busBoy.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson Interrupted");
        }
    }
}
