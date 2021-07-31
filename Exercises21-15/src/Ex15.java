public class Ex15 {

    static class TestLock1 {
        private Object lock = new Object();
        private int count = 0;

        public void a() {
            synchronized (lock) {
                System.out.println(count++);
            }
        }

        public void b() {
            synchronized (lock) {
                System.out.println(count++);
            }
        }

        public void c() {
            synchronized (lock) {
                System.out.println(count++);
            }
        }
    }

    static class TestLock2 {
        private Object lock1 = new Object();
        private Object lock2 = new Object();
        private Object lock3 = new Object();

        public void a() {
            synchronized (lock1) {
                System.out.println("a");
            }Thread.yield();
        }

        public void b() {
            synchronized (lock2) {
                System.out.println("b");
            }Thread.yield();
        }

        public void c() {
            synchronized (lock3) {
                System.out.println("c");
            }Thread.yield();
        }
    }

    public static void main(String[] args) {
        //TestLock1 testLock = new TestLock1();
        TestLock2 testLock = new TestLock2();
        new Thread(){
            public void run() {
                for (int i = 0; i < 10; i++) {
                    testLock.a();
                }
            }
        }.start();
        new Thread(){
            public void run() {
                for (int i = 0; i < 10; i++) {
                    testLock.b();
                }

            }
        }.start();
        for (int i = 0; i < 10; i++) {
            testLock.c();
        }
    }
}
