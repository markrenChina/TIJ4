package ex40;

import java.lang.reflect.Method;

class Pet {
    void speak(){}
}

public class Apply {

    public static <T extends Pet>
    void apply(T t, Method f, Object... args) {
        try {
            f.invoke(t,args);
        }catch (Exception e) {
            //Failures are programmer errors
            throw new RuntimeException(e);
        }
    }
}
