import java.util.concurrent.TimeUnit;

/**
 * 厨师
 * 当meal不为空时，等待
 * 唤醒后，生成meal，并唤醒服务员消费
 */
public class Chef implements Runnable{
    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            //取消sleep 将由while中断，并不抛出异常
            while (!Thread.interrupted()){
                synchronized (this) {
                    while (restaurant.meal != null){
                        wait();
                    }
                }
                if (++count == 10){
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up! ");
                //waitPerson锁chef，保证不会同时notifyAll
                synchronized (restaurant.waitPerson){
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                //收到中断指令会执行到sleep并抛出异常
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.out.println("Chef interrupted");
        }
    }
}
