package ex21;

import java.util.concurrent.atomic.AtomicInteger;

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingsElse "+ arg);
    }
}

class SimpleProxy implements Interface {

    private final AtomicInteger count = new AtomicInteger(0);
    private Interface proxied;
    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }


    @Override
    public void doSomething() {
        count.incrementAndGet();
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
        System.out.println(count);
    }

    @Override
    public void somethingElse(String arg) {
        count.incrementAndGet();
        System.out.println("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
        System.out.println(count);
    }
}

public class Ex21 {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        System.out.println("=====================");
        consumer(new SimpleProxy(new RealObject()));
    }
}
