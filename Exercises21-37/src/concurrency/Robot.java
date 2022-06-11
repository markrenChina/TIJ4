package concurrency;

import java.util.concurrent.BrokenBarrierException;

abstract class Robot implements Runnable{
    protected Assembler assembler;
    private RobotPool pool;
    private boolean engage = false;
    public Robot(RobotPool p) {pool = p;}

    public Robot assignAssembler(Assembler assembler){
        this.assembler = assembler;
        return this;
    }

    public synchronized void engage(){
        engage = true;
        notifyAll();
    }

    //The part of run() that's different for each robot;
    abstract protected void performService();

    @Override
    public void run() {
        try {
            powerDown(); //Wait until needed
            while (!Thread.interrupted()) {
                performService();
                assembler.getBarrier().await(); //Synchronize
                //We're done with that job...
                powerDown();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting " + this +" via interrupt");
        }catch (BrokenBarrierException e) {
            //This one we want to know about
            throw new RuntimeException(e);
        }
        System.out.println(this + " off");
    }

    private synchronized void powerDown() throws  InterruptedException {
        engage = false;
        assembler = null; //Disconnect from the Assembler
        //Put ourselves back in the available pool
        pool.release(this);
        while (engage == false){
            //Power down
            wait();
        }
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
