public class ExceptionThread2 implements Runnable{
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = "+ t.getUncaughtExceptionHandler());

        try {
            CaptureUncaughtException.testThreadPoolExecutor++;
            throw new RuntimeException();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }
}
