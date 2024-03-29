package ex39;

import net.mindview.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

interface Colored {
    int getColor();
}

class MixinProxy implements InvocationHandler {
    Map<String, Object> delegatesByMethod;

    public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String methodName = method.getName();
                //The first interface in the map
                //implements the method
                if (!delegatesByMethod.containsKey(methodName)) {
                    delegatesByMethod.put(methodName, pair.first);
                }
            }
        }
    }

    public static Object newInstance(TwoTuple... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].second;
        }
        ClassLoader cl = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }
}

class ColoredImpl implements Colored {
    private final int color;

    public ColoredImpl(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }
}

public class DynamicProxyMixin {

    public static void main(String[] args) {
//        Object mixin = MixinProxy.newInstance(
//                new TwoTuple<>(new BasicImp(), Basic.class),
//                new TwoTuple<>(new TimeStampedImp(), TimeStamped.class),
//                new TwoTuple<>(new SerialNumberedImp(),SerialNumbered.class)
//        );
        Object mixin = MixinProxy.newInstance(
                new TwoTuple<>(new ColoredImpl(126525), Colored.class)
        );
//        Basic b = (Basic) mixin;
//        TimeStamped t = (TimeStamped) mixin;
//        SerialNumbered s = (SerialNumbered) mixin;
        Colored colored = (Colored) mixin;
        System.out.println(colored.getColor());
//        b.set("Hello");
//        System.out.println(b.get());
//        System.out.println(t.getStamp());
//        System.out.println(s.getSerialNumber());
    }
}