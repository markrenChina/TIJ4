package typeinfo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler3 implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler3(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: "+ method + ", args: "+args);
        for (Field f: proxy.getClass().getDeclaredFields()) {
            System.out.println(f);
        }
        for (Method m: proxy.getClass().getDeclaredMethods()) {
            System.out.println(m);
        }
        if (args != null){
            for (Object arg : args) {
                System.out.println("  " + arg);
            }
            return method.invoke(proxied,args);
        }
        return null;
    }
}
public class Ex23 {
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
                new DynamicProxyHandler3(real)
        );
        consumer(proxy);
    }
}