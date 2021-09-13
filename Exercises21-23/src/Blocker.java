public class Blocker {

    synchronized void waitingCall() {
        try{
            //线程应该始终覆盖循环中断判断方法
            while (!Thread.interrupted()){
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        }catch (InterruptedException e) {
            //Ok to exit this way
        }
    }

    synchronized void prod() { notify(); }

    synchronized void prodAll() { notifyAll(); }
}
