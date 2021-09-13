import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex16 {

    static class TestLock1 {
        private Lock lock = new ReentrantLock();
        private int count = 0;

        public void a() {
            lock.lock();
            try {
                System.out.println(count++);
            }finally {
                lock.unlock();
            }
        }

        public void b() {
            lock.lock();
            try {
                System.out.println(count++);
            }finally {
                lock.unlock();
            }
        }

        public void c() {
            lock.lock();
            try {
                System.out.println(count++);
            }finally {
                lock.unlock();
            }
        }
    }

    static class TestLock2 {
        private Lock lock1 = new ReentrantLock();
        private Lock lock2 = new ReentrantLock();
        private Lock lock3 = new ReentrantLock();

        public void a() {
            lock1.lock();
            try {
                System.out.println("a");
            }finally {
                lock1.unlock();
            }
            Thread.yield();
        }

        public void b() {
            lock2.lock();
            try {
                System.out.println("b");
            }finally {
                lock2.unlock();
            }
            Thread.yield();
        }

        public void c() {
            lock3.lock();
            try {
                System.out.println("c");
            }finally {
                lock3.unlock();
            }
            Thread.yield();
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
