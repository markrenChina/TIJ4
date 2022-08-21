package generics;

interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {}

public class SelfBoundingAndCovariantArguments {
    void testA(Setter s1,Setter s2,SelfBoundSetter sbs){
        s1.set(s2);
        //s1.set(sbs); //Error
        //编译器不能识别将基类型当作参数传递给set()的尝试，因为没有任何方法具有这样的签名。
        //实际上，这个参数已经被覆盖了
    }
}
