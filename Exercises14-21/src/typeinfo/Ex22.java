package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicInteger;

class DynamicProxyHandler2 implements InvocationHandler {
    private Object proxied;
    private AtomicInteger count = new AtomicInteger(0);

    public DynamicProxyHandler2(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(count.incrementAndGet());
        System.out.println("**** proxy: " + proxy.getClass() + ", method: "+ method + ", args: "+args);
        if (args != null){
            for (Object arg : args) {
                System.out.println("  " + arg);
            }
            return method.invoke(proxied,args);
        }
        return null;
    }
}
public class Ex22 {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        //Insert a proxy and call again;
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[] { Interface.class },
                new DynamicProxyHandler2(real)
        );
        consumer(proxy);
    }
}