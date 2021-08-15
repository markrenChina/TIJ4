
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
                    while (restaurant.meal == null) {
                        wait(); //... for the chef to produce a meal
                    }
                }
                System.out.println("Waitperson got " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll(); //Ready for another
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson Interrupted");
        }
    }
}
