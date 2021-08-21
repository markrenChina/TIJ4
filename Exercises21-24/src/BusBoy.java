public class BusBoy implements Runnable{

    private Restaurant restaurant;

    public BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    while (restaurant.table.state){
                        wait(); //wait the waitPerson to clear
                    }
                }
                System.out.println("to clear table");
                synchronized (restaurant.waitPerson){
                    restaurant.table.state = true;
                    restaurant.waitPerson.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("BusBoy Interrupted");
        }
    }
}
