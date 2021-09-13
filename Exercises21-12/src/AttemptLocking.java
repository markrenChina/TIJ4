import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * untimed尝试去获取锁，获取不到可以执行别的
 * timed尝试2秒内获取，获取不到进入catch，可以执行别的代码
 */
public class AttemptLocking {
   private final ReentrantLock lock = new ReentrantLock();

   public void untimed() {
      System.out.println("untimed");
      boolean captured = lock.tryLock();
      try {
         System.out.println("tryLock(): " + captured);
      }finally {
         if (captured){
            lock.unlock();
         }
      }
   }

   public void timed(){
      System.out.println("timed");
      boolean captured = false;
      try {
         captured = lock.tryLock(2, TimeUnit.SECONDS);
      }catch (InterruptedException e){
         throw new RuntimeException(e);
      }
      try{
         System.out.println("tryLock(2, TimeUnit.SECONDS): "+ captured);
      }finally {
         if (captured){
            lock.unlock();
         }
      }
   }

   public static void main(String[] args) throws InterruptedException {
      final AttemptLocking al = new AttemptLocking();
      al.untimed();
      al.timed();
      new Thread(){
         { setDaemon(true); }

         @Override
         public void run() {
            al.lock.lock();
            System.out.println("acquired");
         }
      }.start();
      //Thread.yield();
      Thread.sleep(100);
      al.untimed();
      al.timed();

   }

}
